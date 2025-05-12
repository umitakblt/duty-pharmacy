package com.umitakbulut.duty_pharmacy.service.impl;

import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResponseDTO;
import com.umitakbulut.duty_pharmacy.external.dutypharmacy.DutyPharmacyExternalService;
import com.umitakbulut.duty_pharmacy.service.DutyPharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DutyPharmacyServiceImpl implements DutyPharmacyService {
    private final DutyPharmacyExternalService dutyPharmacyExternalService;

    @Override
    public DutyPharmacyResponseDTO checkDutyPharmacy(DutyPharmacyRequestDTO dutyPharmacyRequestDTO) {

        // Dış servise istek atılacak

        // hata alma durumunda bizim exception üretilecek

        // error durumları kontrol edilecek

        // hazelcast ve database durumlarına yarına bırak.
        return null;
    }
}
