package com.laridosos.rest.treatment.dto;

import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TreatmentGetDTO {
    private Long id;
    private LocalDate beginDate;
    private LocalDate endDate;
    private DiseaseGetDTO disease;
    private PatientGetDTO patient;
}
