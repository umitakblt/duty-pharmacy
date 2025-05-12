package com.umitakbulut.duty_pharmacy.external.dutypharmacy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result implements Serializable {
    @Serial
    private static final long serialVersionUID = 3382116064493077434L;
    private String name;
    private String dist;
    private String address;
    private String phone;
    @JsonProperty(value = "loc")
    private String location;
}
