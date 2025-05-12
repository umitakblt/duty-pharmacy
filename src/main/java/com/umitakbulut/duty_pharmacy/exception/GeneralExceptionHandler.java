package com.umitakbulut.duty_pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DutyPharmacyException.class)
    public ResponseEntity<?> authorizationExceptionHandler(DutyPharmacyException userException) {
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(userException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), userException.getKey()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
