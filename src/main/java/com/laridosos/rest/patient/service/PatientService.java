package com.laridosos.rest.patient.service;

import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.treatment.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;

public interface PatientService {
    Patient patch(Patient patient, Patient patientDataToUpdate);

    Patient save(Patient toPatient);

    Patient findById(Patient patient);

    Page<Treatment> findAllTreatmentsByPatientId(Long id, Pageable pageable);
}
