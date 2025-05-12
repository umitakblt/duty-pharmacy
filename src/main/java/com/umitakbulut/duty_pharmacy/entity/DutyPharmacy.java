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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "district_name", nullable = false)
    private String districtName;

    @Column(name = "city_name", nullable = false)
    private String cityName;
}
