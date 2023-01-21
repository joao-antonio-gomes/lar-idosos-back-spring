package com.laridosos.rest.patient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.persons.GenderEnum;

import java.time.LocalDate;

public record PatientGetDTO(
        Long id,
        String name,
        String cpf,
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate birthDate,
        GenderEnum gender,
        MaritalStatusEnum maritalStatus
) {

    public PatientGetDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getCpf(), patient.getBirthDate(), patient.getGender(), patient.getMaritalStatus());
    }
}
