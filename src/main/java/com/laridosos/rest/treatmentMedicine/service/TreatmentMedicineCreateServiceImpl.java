package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.medicineApplication.service.MedicineApplicationCreateService;
import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TreatmentMedicineCreateServiceImpl implements TreatmentMedicineCreateService {

    private final TreatmentMedicineRepository repository;
    private final MedicineApplicationCreateService medicineApplicationCreateService;
    private final TreatementMedicineCreateValidator validator;

    public TreatmentMedicineCreateServiceImpl(TreatmentMedicineRepository repository,
                                              TreatementMedicineCreateValidator validator,
                                              MedicineApplicationCreateService medicineApplicationCreateService) {
        this.repository = repository;
        this.validator = validator;
        this.medicineApplicationCreateService = medicineApplicationCreateService;
    }

    @Override
    public Collection<TreatmentMedicine> create(Treatment treatment) {
        Collection<TreatmentMedicine> treatmentMedicines = treatment.getTreatmentMedicines();

        treatmentMedicines.forEach(treatmentMedicine -> {
            treatmentMedicine.setTreatment(treatment);
            validator.validate(treatmentMedicine);
            TreatmentMedicine treatmentSaved = repository.save(treatmentMedicine);
            medicineApplicationCreateService.create(treatmentSaved);
        });

        return treatmentMedicines;
    }
}
