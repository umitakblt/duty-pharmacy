package com.umitakbulut.duty_pharmacy.async;

import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResult;

import java.util.List;

public interface AsyncService {
    void saveDatabase(List<DutyPharmacyResult> results, DutyPharmacyRequestDTO dutyPharmacyRequestDTO);
}
