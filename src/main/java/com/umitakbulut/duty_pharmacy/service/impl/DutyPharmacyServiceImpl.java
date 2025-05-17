package com.umitakbulut.duty_pharmacy.service.impl;

import com.umitakbulut.duty_pharmacy.async.AsyncService;
import com.umitakbulut.duty_pharmacy.config.AppConfiguration;
import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResponseDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResult;
import com.umitakbulut.duty_pharmacy.exception.DutyPharmacyException;
import com.umitakbulut.duty_pharmacy.exception.DutyPharmacyExceptionEnum;
import com.umitakbulut.duty_pharmacy.external.dutypharmacy.DutyPharmacyExternalService;
import com.umitakbulut.duty_pharmacy.external.dutypharmacy.model.DutyPharmacyResponse;
import com.umitakbulut.duty_pharmacy.service.DutyPharmacyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DutyPharmacyServiceImpl implements DutyPharmacyService {
    private static final Logger log = LoggerFactory.getLogger(DutyPharmacyServiceImpl.class);
    private final DutyPharmacyExternalService dutyPharmacyExternalService;
    private final AppConfiguration appConfiguration;
    private final AsyncService asyncService;

    @Cacheable(key = "#dutyPharmacyRequestDTO.cityName + #dutyPharmacyRequestDTO.districtName", value = "dutyChecks")
    public DutyPharmacyResponseDTO checkDutyPharmacy(DutyPharmacyRequestDTO dutyPharmacyRequestDTO) {
        log.info("DutyPharmacyServiceImpl.checkDutyPharmacy(): dutyPharmacyRequestDTO: {}", dutyPharmacyRequestDTO);

        DutyPharmacyResponse dutyPharmacyResponse = null;
        try {
            dutyPharmacyResponse = this.dutyPharmacyExternalService.getDutyPharmacy(dutyPharmacyRequestDTO.getDistrictName(), dutyPharmacyRequestDTO.getCityName(), appConfiguration.getExternalService().getToken());
        } catch (Exception exception) {
            log.error("DutyPharmacyServiceImpl.checkDutyPharmacy(): exceptionMessage: {} ", exception.getMessage(), exception);
            throw new DutyPharmacyException(DutyPharmacyExceptionEnum.DUTY_PHARMACY_EXTERNAL_SERVICE_ERROR);
        }

        if (dutyPharmacyResponse == null ||
            !dutyPharmacyResponse.getSuccess() ||
            dutyPharmacyResponse.getResult() == null ||
            dutyPharmacyResponse.getResult().isEmpty()) {
            log.error("DutyPharmacyServiceImpl.checkDutyPharmacy(): DutyPharmacyResponse is null or empty");
            throw new DutyPharmacyException(DutyPharmacyExceptionEnum.DUTY_PHARMACY_EXTERNAL_SERVICE_NULL_ERROR);
        }

        List<DutyPharmacyResult> results = dutyPharmacyResponse.getResult().stream().map(duty -> DutyPharmacyResult
                .builder().name(duty.getName())
                .dist(duty.getDist())
                .phone(duty.getPhone())
                .address(duty.getAddress())
                .location(duty.getLocation())
                .build()).toList();

        this.asyncService.saveDatabase(results, dutyPharmacyRequestDTO);

        return new DutyPharmacyResponseDTO(results);
    }
}
