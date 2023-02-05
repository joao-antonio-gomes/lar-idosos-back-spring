package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;

import java.util.List;

public interface TreatmentMedicineService {
    List<TreatmentMedicine> create(Treatment treatment);
}
