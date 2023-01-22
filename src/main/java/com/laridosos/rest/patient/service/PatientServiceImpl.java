package com.laridosos.rest.patient.service;

import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Patient patch(Patient patient, Patient patientDataToUpdate) {
        replacePatientData(patient, patientDataToUpdate);

        return patientRepository.save(patient);
    }

    private void replacePatientData(Patient patient, Patient patientDataToUpdate) {
        if (patientDataToUpdate.getName() != null)
            patient.setName(patientDataToUpdate.getName());

        if (patientDataToUpdate.getCpf() != null)
            patient.setCpf(patientDataToUpdate.getCpf());

        if (patientDataToUpdate.getBirthDate() != null)
            patient.setBirthDate(patientDataToUpdate.getBirthDate());

        if (patientDataToUpdate.getGender() != null)
            patient.setGender(patientDataToUpdate.getGender());

        if (patientDataToUpdate.getMaritalStatus() != null)
            patient.setMaritalStatus(patientDataToUpdate.getMaritalStatus());
    }
}
