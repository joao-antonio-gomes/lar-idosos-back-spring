package com.laridosos.rest.treatment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    @Query("SELECT t FROM Treatment t JOIN t.disease d WHERE (:id is null or t.patient.id = :id)")
    Page<Treatment> findAllByPatientId(Long id, Pageable pageable);
}
