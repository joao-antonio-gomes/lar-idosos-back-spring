package com.laridosos.rest.patient.dto;

import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TreatmentGetWithoutPatientDTO {
    private Long id;
    private LocalDate beginDate;
    private LocalDate endDate;
    private DiseaseGetDTO disease;
}
