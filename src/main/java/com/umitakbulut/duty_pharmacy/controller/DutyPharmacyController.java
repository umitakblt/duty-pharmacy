package com.umitakbulut.duty_pharmacy.controller;

import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResponseDTO;
import com.umitakbulut.duty_pharmacy.service.DutyPharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/v1/duty-pharmacy")
@RequiredArgsConstructor
public class DutyPharmacyController {
    private final DutyPharmacyService dutyPharmacyService;

    @GetMapping(value = "/check")
    public ResponseEntity<DutyPharmacyResponseDTO> checkDutyPharmacy(@RequestBody DutyPharmacyRequestDTO dutyPharmacyRequestDTO) {
        return ResponseEntity.ok(this.dutyPharmacyService.checkDutyPharmacy(dutyPharmacyRequestDTO));
    }
}
