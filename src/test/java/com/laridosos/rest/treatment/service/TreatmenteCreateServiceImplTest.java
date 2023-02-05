package com.laridosos.rest.treatment.service;

import com.laridosos.rest.disease.Disease;
import com.laridosos.rest.disease.service.DiseaseService;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.service.PatientService;
import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatment.TreatmentRepository;
import com.laridosos.rest.treatmentMedicine.service.TreatmentMedicineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TreatmenteCreateServiceImplTest {

    @Mock
    private TreatmentRepository repository;
    @Mock
    private TreatmentMedicineService treatmentMedicineService;
    @Mock
    private DiseaseService diseaseService;
    @Mock
    private PatientService patientService;

    @Captor
    private ArgumentCaptor<Treatment> treatmentCaptor;

    private TreatmenteCreateServiceImpl service;

    @BeforeEach
    void setUp() {
        this.service = new TreatmenteCreateServiceImpl(repository,
                treatmentMedicineService,
                diseaseService,
                patientService);
    }

    @Test
    public void deveCriarUmTratamento() {
        when(diseaseService.findById(any(Disease.class))).thenReturn(createDisease());
        when(patientService.findById(any(Patient.class))).thenReturn(createPatient());
        when(repository.save(any(Treatment.class))).thenReturn(createTreatment());

        service.create(createTreatment());

        verify(diseaseService, times(1)).findById(any(Disease.class));
        verify(patientService, times(1)).findById(any(Patient.class));
        verify(repository, times(1)).save(treatmentCaptor.capture());
        verify(treatmentMedicineService, times(1)).create(any(Treatment.class));
    }

    private Patient createPatient() {
        Patient patient = new Patient();
        return patient;
    }

    private Treatment createTreatment() {
        Treatment treatment = new Treatment();
        treatment.setDisease(createDisease());
        treatment.setPatient(createPatient());
        return treatment;
    }

    private Disease createDisease() {
        Disease disease = new Disease();
        return disease;
    }
}
