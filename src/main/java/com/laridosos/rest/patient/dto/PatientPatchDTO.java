package com.laridosos.rest.patient.dto;

import com.laridosos.annotation.validation.CPF;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.user.dto.UserGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class PatientPatchDTO {
    private String name;
    @CPF
    private String cpf;
    private LocalDate birthDate;
    private GenderEnum gender;
    private MaritalStatusEnum maritalStatus;
    private UserGetDTO responsible;
}
