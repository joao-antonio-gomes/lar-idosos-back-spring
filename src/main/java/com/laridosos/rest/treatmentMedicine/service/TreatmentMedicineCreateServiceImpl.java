package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TreatmentMedicineCreateServiceImpl implements TreatmentMedicineCreateService {

    private final TreatmentMedicineRepository repository;
    private final TreatementMedicineCreateValidator validator;

    public TreatmentMedicineCreateServiceImpl(TreatmentMedicineRepository repository,
                                              TreatementMedicineCreateValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Collection<TreatmentMedicine> create(Treatment treatment) {
        Collection<TreatmentMedicine> treatmentMedicines = treatment.getTreatmentMedicines();

        treatmentMedicines.stream().map(treatmentMedicine -> {
            treatmentMedicine.setTreatment(treatment);
            validator.validate(treatmentMedicine);
            return treatmentMedicine;
        });

        return treatmentMedicines;
    }
}
