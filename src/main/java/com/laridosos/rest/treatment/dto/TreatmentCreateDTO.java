package com.laridosos.rest.treatment.dto;

import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentCreateDTO {
    private Long patientId;
    private Long diseaseId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private List<TreatmentMedicineCreateDTO> treatmentMedicines;
}
