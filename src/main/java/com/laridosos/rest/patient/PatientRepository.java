package com.laridosos.rest.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE (:name is null or LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    Page<Patient> findAllByNameIgnoreCaseContaining(String name, Pageable pageable);
}
