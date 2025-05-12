package com.umitakbulut.duty_pharmacy.repository;

import com.umitakbulut.duty_pharmacy.entity.DutyPharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyPharmacyRepository extends JpaRepository<DutyPharmacy, Long> {
}
