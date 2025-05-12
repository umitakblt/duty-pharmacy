package com.umitakbulut.duty_pharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum DutyPharmacyExceptionEnum {
    DUTY_PHARMACY_EXTERNAL_SERVICE_ERROR("DutyPharmacy External Service Error", "DUTY_PHARMACY_EXTERNAL_SERVICE_ERROR"),
    DUTY_PHARMACY_EXTERNAL_SERVICE_NULL_ERROR("DutyPharmacy External Service Null Error", "DUTY_PHARMACY_EXTERNAL_SERVICE_NULL_ERROR");

    private final String message;
    private final String key;
}
