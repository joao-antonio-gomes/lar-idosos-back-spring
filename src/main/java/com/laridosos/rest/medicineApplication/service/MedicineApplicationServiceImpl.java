package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.medicineApplication.MedicineApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineApplicationServiceImpl implements MedicineApplicationService {

    private final MedicineApplicationRepository repository;

    public MedicineApplicationServiceImpl(MedicineApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MedicineApplication> findById(Long applicationId) {
        return repository.findById(applicationId);
    }

    @Override
    public void applyMedicineApplication(MedicineApplication medicineApplication) {
        medicineApplication.setApplied(true);
        repository.save(medicineApplication);
    }

    @Override
    public void unapplyMedicineApplication(MedicineApplication medicineApplication) {
        medicineApplication.setApplied(false);
        repository.save(medicineApplication);
    }
}
