package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentMedicineServiceImpl implements TreatmentMedicineService {

    private TreatmentMedicineRepository repository;

    public TreatmentMedicineServiceImpl(TreatmentMedicineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TreatmentMedicine> create(Treatment treatment) {
        return null;
    }
}
