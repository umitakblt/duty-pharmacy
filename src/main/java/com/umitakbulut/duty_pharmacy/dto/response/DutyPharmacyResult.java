package com.umitakbulut.duty_pharmacy.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DutyPharmacyResult implements Serializable {
    @Serial
    private static final long serialVersionUID = -2446737051216000757L;

    private String name;

    private String dist;

    private String address;

    private String phone;

    private String location;
}
