package com.laridosos.rest.patient.service;

import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.PatientRepository;
import com.laridosos.rest.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final UserService userService;

    public PatientServiceImpl(PatientRepository patientRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
    }


    @Override
    public Patient patch(Patient patient, Patient patientDataToUpdate) {
        if (patientDataToUpdate.getResponsible() != null)
            patientDataToUpdate.setResponsible(userService.findById(patientDataToUpdate.getResponsible()
                                                                                       .getId()));

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

        if (patientDataToUpdate.getResponsible() != null)
            patient.setResponsible(patientDataToUpdate.getResponsible());
    }

    @Override
    public Patient save(Patient patient) {
        if (patient.getResponsible() != null)
            patient.setResponsible(userService.findById(patient.getResponsible()
                                                               .getId()));

        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Patient patient) {
        return null;
    }
}
