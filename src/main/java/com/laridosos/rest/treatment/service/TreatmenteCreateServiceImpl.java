package com.laridosos.rest.treatment.service;

import com.laridosos.rest.disease.service.DiseaseService;
import com.laridosos.rest.patient.service.PatientService;
import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatment.TreatmentRepository;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.service.TreatmentMedicineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmenteCreateServiceImpl implements TreatmentCreateService {

    private final TreatmentRepository repository;
    private final TreatmentMedicineService treatmentMedicineService;
    private final DiseaseService diseaseService;
    private final PatientService patientService;

    public TreatmenteCreateServiceImpl(TreatmentRepository repository,
                                       TreatmentMedicineService treatmentMedicineService,
                                       DiseaseService diseaseService,
                                       PatientService patientService) {
        this.repository = repository;
        this.treatmentMedicineService = treatmentMedicineService;
        this.diseaseService = diseaseService;
        this.patientService = patientService;
    }

    @Override
    public Treatment create(Treatment treatment) {
        diseaseService.findById(treatment.getDisease());
        patientService.findById(treatment.getPatient());

        Treatment treatmentSaved = repository.save(treatment);

        List<TreatmentMedicine> treatmentsMedicine = treatmentMedicineService.create(treatmentSaved);

        treatmentSaved.setTreatmentMedicines(treatmentsMedicine);

        return treatmentSaved;
    }
}
