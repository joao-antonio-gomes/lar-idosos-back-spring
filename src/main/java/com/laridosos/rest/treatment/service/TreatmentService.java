package com.laridosos.rest.treatment.service;

import com.laridosos.rest.treatment.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TreatmentService {
    Page<Treatment> findAllByPatientId(Long id, Pageable pageable);
}
