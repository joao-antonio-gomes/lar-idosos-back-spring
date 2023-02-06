package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;

import java.util.Collection;

public interface TreatmentMedicineCreateService {
    Collection<TreatmentMedicine> create(Treatment treatment);
}
