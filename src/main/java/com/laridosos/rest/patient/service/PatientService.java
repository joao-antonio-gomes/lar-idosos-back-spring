package com.laridosos.rest.patient.service;

import com.laridosos.rest.patient.Patient;

public interface PatientService {
    Patient patch(Patient patient, Patient patientDataToUpdate);
}
