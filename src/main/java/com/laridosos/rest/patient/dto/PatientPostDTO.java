package com.laridosos.rest.patient.dto;

import com.laridosos.annotation.validation.CPF;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.user.UserApp;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record PatientPostDTO(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @CPF
        @NotBlank(message = "CPF é obrigatório")
        String cpf,
        @NotBlank(message = "Gênero é obrigatório")
        GenderEnum gender,
        @NotBlank(message = "Estado civil é obrigatório")
        MaritalStatusEnum maritalStatus,
        @NotBlank(message = "Data de nascimento é obrigatório")
        LocalDate birthDate,
        Long userId
) {

    public Patient toPatient() {
        Patient patient = Patient.builder()
                                 .name(name)
                                 .cpf(cpf)
                                 .gender(gender)
                                 .maritalStatus(maritalStatus)
                                 .birthDate(birthDate)
                                 .build();

        if (userId == null)
            return patient;

        patient.setUsersApp(List.of(UserApp.builder().id(userId).build()));
        return patient;
    }
}
