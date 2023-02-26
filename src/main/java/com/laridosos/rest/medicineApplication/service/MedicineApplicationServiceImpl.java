package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.medicineApplication.MedicineApplicationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<MedicineApplication> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, List<MedicineApplication>> findAllByStatusApplied() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        Pageable pageSize = Pageable.ofSize(20);
        List<MedicineApplication> medApplicationsLated = repository.findLatedMedicineApplication(dateNow, timeNow, pageSize)
                                                                   .getContent();
        List<MedicineApplication> medApplicationsToBeApplied = repository.findToBeAppliedMedicineApplication(dateNow, timeNow, pageSize)
                                                                         .getContent();

        return Map.of(
                "lated", medApplicationsLated,
                "toBeApplied", medApplicationsToBeApplied
        );
    }
}
