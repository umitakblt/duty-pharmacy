package com.umitakbulut.duty_pharmacy.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DutyPharmacyException extends RuntimeException {
    private final String key;

    public DutyPharmacyException(DutyPharmacyExceptionEnum dutyPharmacyExceptionEnum) {
        super();
        this.key = dutyPharmacyExceptionEnum.getKey();
    }

}
