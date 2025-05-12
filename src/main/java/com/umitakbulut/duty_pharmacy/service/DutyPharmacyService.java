package com.umitakbulut.duty_pharmacy.service;

import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResponseDTO;

public interface DutyPharmacyService {
    DutyPharmacyResponseDTO checkDutyPharmacy(DutyPharmacyRequestDTO dutyPharmacyRequestDTO);
}
