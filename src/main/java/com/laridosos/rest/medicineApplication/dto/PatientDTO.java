package com.laridosos.rest.medicineApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.persons.GenderEnum;
import com.laridosos.rest.persons.MaritalStatusEnum;
import com.laridosos.rest.treatment.dto.TreatmentGetWithoutPatientDTO;
import com.laridosos.rest.user.dto.UserGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@AllArgsConstructor
public final class PatientDTO {
    private Long id;
    private String name;
    private String cpf;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private GenderEnum gender;
    private MaritalStatusEnum maritalStatus;
}
