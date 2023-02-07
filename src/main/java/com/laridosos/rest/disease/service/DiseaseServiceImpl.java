package com.laridosos.rest.disease.service;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.disease.Disease;
import com.laridosos.rest.disease.DiseaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository repository;

    public DiseaseServiceImpl(DiseaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Disease findById(Disease disease) {
        return repository.findById(disease.getId()).orElseThrow(() -> new ResourceNotFoundException("Doença com id " + disease.getId() + " não encontrada"));
    }
}
