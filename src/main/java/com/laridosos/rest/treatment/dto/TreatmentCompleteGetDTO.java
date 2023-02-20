package com.laridosos.rest.treatment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.patient.dto.PatientGetWithoutTreatmentDTO;
import com.laridosos.rest.treatment.TreatmentStatus;
import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCompleteGetDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class TreatmentCompleteGetDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private TreatmentStatus status;
    private DiseaseGetDTO disease;
    private PatientGetWithoutTreatmentDTO patient;
    private List<TreatmentMedicineCompleteGetDTO> treatmentMedicines;
}
