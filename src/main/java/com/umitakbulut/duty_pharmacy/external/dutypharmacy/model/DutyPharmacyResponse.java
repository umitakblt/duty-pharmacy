package com.umitakbulut.duty_pharmacy.external.dutypharmacy.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DutyPharmacyResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -8437053962053222212L;
    private Boolean success;
    private List<Result> result;
}
