package com.laridosos.rest.treatment.service;

import com.laridosos.rest.disease.Disease;
import com.laridosos.rest.disease.service.DiseaseService;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.service.PatientService;
import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatment.TreatmentRepository;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.service.TreatmentMedicineCreateService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TreatmentCreateServiceImpl implements TreatmentCreateService {

    private final TreatmentRepository repository;
    private final TreatmentMedicineCreateService treatmentMedicineCreateService;
    private final DiseaseService diseaseService;
    private final PatientService patientService;
    private final TreatmentCreateValidator validator;

    public TreatmentCreateServiceImpl(TreatmentRepository repository,
                                      TreatmentMedicineCreateService treatmentMedicineCreateService,
                                      DiseaseService diseaseService,
                                      PatientService patientService,
                                      TreatmentCreateValidator validator) {
        this.repository = repository;
        this.treatmentMedicineCreateService = treatmentMedicineCreateService;
        this.diseaseService = diseaseService;
        this.patientService = patientService;
        this.validator = validator;
    }

    @Override
    public Treatment create(Treatment treatment) {
        validator.validate(treatment);

        Disease disease = diseaseService.findById(treatment.getDisease());
        Patient patient = patientService.findById(treatment.getPatient());
        treatment.setDisease(disease);
        treatment.setPatient(patient);

        Treatment treatmentSaved = repository.save(treatment);

        Collection<TreatmentMedicine> treatmentsMedicine = treatmentMedicineCreateService.create(treatmentSaved);

        treatmentSaved.setTreatmentMedicines(treatmentsMedicine);

        return treatmentSaved;
    }
}
