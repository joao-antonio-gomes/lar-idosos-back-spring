package com.laridosos.rest.patient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.user.dto.UserGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public final class PatientGetDTO {
    private Long id;
    private String name;
    private String cpf;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private GenderEnum gender;
    private MaritalStatusEnum maritalStatus;
    private UserGetDTO responsible;

}
