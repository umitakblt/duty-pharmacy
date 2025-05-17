package com.umitakbulut.duty_pharmacy.controller;

import com.umitakbulut.duty_pharmacy.dto.request.DutyPharmacyRequestDTO;
import com.umitakbulut.duty_pharmacy.dto.response.DutyPharmacyResponseDTO;
import com.umitakbulut.duty_pharmacy.service.DutyPharmacyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
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
    @Operation(
            summary = "Duty Pharmacy Check",
            description = "Duty Pharmacy Check",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Duty Pharmacy cityName and districtName",
                    required = true,
                    content = @Content(schema = @Schema(implementation = DutyPharmacyRequestDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Duty Pharmacy Check success"),
                    @ApiResponse(responseCode = "400", description = "Duty Pharmacy Check validation error"),
                    @ApiResponse(responseCode = "500", description = "Duty Pharmacy Check error")
            }
    )
    public ResponseEntity<DutyPharmacyResponseDTO> checkDutyPharmacy(@Valid @RequestBody DutyPharmacyRequestDTO dutyPharmacyRequestDTO) {
        return ResponseEntity.ok(this.dutyPharmacyService.checkDutyPharmacy(dutyPharmacyRequestDTO));
    }
}
