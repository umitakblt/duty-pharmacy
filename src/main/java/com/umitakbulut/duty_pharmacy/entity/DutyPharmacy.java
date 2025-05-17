package com.umitakbulut.duty_pharmacy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "duty_pharmacy")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DutyPharmacy implements Serializable {
    @Serial
    private static final long serialVersionUID = -6487996242046884555L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "district_name", nullable = false)
    private String districtName;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Lob
    @Column(name = "duty_pharmacies", nullable = false, length = 65535)
    private String dutyPharmacies;
}
