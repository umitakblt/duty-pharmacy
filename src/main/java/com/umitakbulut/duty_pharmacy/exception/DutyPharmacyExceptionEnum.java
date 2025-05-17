package com.umitakbulut.duty_pharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DutyPharmacyExceptionEnum {
    DUTY_PHARMACY_EXTERNAL_SERVICE_ERROR("DutyPharmacy External Service Error", "DUTY_PHARMACY_EXTERNAL_SERVICE_ERROR"),
    DUTY_PHARMACY_EXTERNAL_SERVICE_NULL_ERROR("DutyPharmacy External Service Null Error", "DUTY_PHARMACY_EXTERNAL_SERVICE_NULL_ERROR"),
    DUTY_PHARMACY_JSON_PARSE_EXCEPTION("DutyPharmacy Json Parse Exception", "DUTY_PHARMACY_JSON_PARSE_EXCEPTION");

    private final String message;
    private final String key;
}
