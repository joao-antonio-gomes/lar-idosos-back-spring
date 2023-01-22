package com.laridosos.rest.patient.dto;

import com.laridosos.annotation.validation.CPF;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;

import java.time.LocalDate;

public record PatientPatchDTO(
        String name,
        @CPF
        String cpf,
        LocalDate birthDate,
        GenderEnum gender,
        MaritalStatusEnum maritalStatus
) {

    public Patient toPatient() {
        return Patient.builder()
                      .name(name)
                      .cpf(cpf)
                      .birthDate(birthDate)
                      .gender(gender)
                      .maritalStatus(maritalStatus)
                      .build();
    }

}
