package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;

import java.util.Collection;

public interface MedicineApplicationCreateService {
    Collection<MedicineApplication> create(TreatmentMedicine treatmentMedicine);
}
