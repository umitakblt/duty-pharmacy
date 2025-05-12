package com.umitakbulut.duty_pharmacy.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDTO implements Serializable {
    private String message;
    private HttpStatus status;
    private int code;
    private String key;
}
