package com.umitakbulut.duty_pharmacy.exception;

import com.umitakbulut.duty_pharmacy.entity.DutyPharmacy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DutyPharmacyException extends RuntimeException {
    private String key;

    public DutyPharmacyException(DutyPharmacyExceptionEnum dutyPharmacyExceptionEnum) {
        super();
        this.key = dutyPharmacyExceptionEnum.getKey();
    }

    public String getKey() {return key;}
}
