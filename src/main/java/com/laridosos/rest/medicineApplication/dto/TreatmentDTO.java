package com.laridosos.rest.medicineApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import com.laridosos.rest.treatment.TreatmentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TreatmentDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private TreatmentStatus status;
    private DiseaseGetDTO disease;
    private PatientDTO patient;
}
