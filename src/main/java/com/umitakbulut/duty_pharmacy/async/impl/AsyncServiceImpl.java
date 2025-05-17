package com.umitakbulut.duty_pharmacy.async.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umitakbulut.duty_pharmacy.async.AsyncService;
import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResult;
import com.umitakbulut.duty_pharmacy.entity.DutyPharmacy;
import com.umitakbulut.duty_pharmacy.exception.DutyPharmacyException;
import com.umitakbulut.duty_pharmacy.exception.DutyPharmacyExceptionEnum;
import com.umitakbulut.duty_pharmacy.repository.DutyPharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
public class AsyncServiceImpl implements AsyncService {
    private final DutyPharmacyRepository dutyPharmacyRepository;
    private final ObjectMapper objectMapper;

    @Async(value = "asyncThreadPoolTaskExecutor")
    @Override
    @Transactional
    public void saveDatabase(List<DutyPharmacyResult> results, DutyPharmacyRequestDTO dutyPharmacyRequestDTO) {
        log.info("AsyncServiceImpl.saveDatabase(): results: {}, dutyPharmacyRequestDTO: {}" , results, dutyPharmacyRequestDTO);
        String dutyPharmacies;
        try {
            dutyPharmacies = this.objectMapper.writeValueAsString(results);
        } catch (JsonProcessingException exception) {
            log.error("DutyPharmacyServiceImpl.checkDutyPharmacy(): JsonProcessingExceptionMessage : {}",exception.getMessage(), exception);
            throw new DutyPharmacyException(DutyPharmacyExceptionEnum.DUTY_PHARMACY_JSON_PARSE_EXCEPTION);
        }

        DutyPharmacy dutyPharmacy = new DutyPharmacy();
        dutyPharmacy.setCityName(dutyPharmacyRequestDTO.getCityName());
        dutyPharmacy.setDistrictName(dutyPharmacyRequestDTO.getDistrictName());
        dutyPharmacy.setDutyPharmacies(dutyPharmacies);
        this.dutyPharmacyRepository.save(dutyPharmacy);
    }
}
