package com.laridosos.rest.treatment.service;

import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatment.TreatmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Page<Treatment> findAllByPatientId(Long id, Pageable pageable) {
        return treatmentRepository.findAllByPatientId(id, pageable);
    }
}
