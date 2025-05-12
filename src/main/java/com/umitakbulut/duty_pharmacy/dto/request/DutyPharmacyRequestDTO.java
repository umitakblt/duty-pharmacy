package com.umitakbulut.duty_pharmacy.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DutyPharmacyRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 404629168770021121L;

    @NotNull(message = "districtName is null")
    @NotEmpty(message = "districtName is empty")
    private String districtName;

    @NotNull(message = "cityName is null")
    @NotEmpty(message = "cityName is empty")
    private String cityName;
}
