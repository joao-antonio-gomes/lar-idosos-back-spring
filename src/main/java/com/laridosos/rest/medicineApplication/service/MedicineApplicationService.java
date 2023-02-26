package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MedicineApplicationService {
    Optional<MedicineApplication> findById(Long applicationId);

    void applyMedicineApplication(MedicineApplication medicineApplication);

    void unapplyMedicineApplication(MedicineApplication medicineApplication);

    List<MedicineApplication> findAll();

    Map<String, List<MedicineApplication>> findAllByStatusApplied();
}
