package com.laridosos.rest.patient.dto;

import com.laridosos.annotation.validation.CPF;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.user.dto.UserGetDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PatientPostDTO {
    private @NotBlank(message = "Nome é obrigatório") String name;
    @CPF
    private @NotBlank(message = "CPF é obrigatório") String cpf;
    private @NotBlank(message = "Gênero é obrigatório") GenderEnum gender;
    private @NotBlank(message = "Estado civil é obrigatório") MaritalStatusEnum maritalStatus;
    private @NotBlank(message = "Data de nascimento é obrigatório") LocalDate birthDate;
    private UserGetDTO responsible;
}
