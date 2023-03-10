package com.laridosos.rest.treatment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.treatment.TreatmentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TreatmentGetDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private TreatmentStatus status;
    private DiseaseGetDTO disease;
    private PatientGetDTO patient;
}
