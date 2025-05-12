package com.umitakbulut.duty_pharmacy.dto.response;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DutyPharmacyResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 766486491759823853L;
    private List<DutyPharmacyResult> results;
}
