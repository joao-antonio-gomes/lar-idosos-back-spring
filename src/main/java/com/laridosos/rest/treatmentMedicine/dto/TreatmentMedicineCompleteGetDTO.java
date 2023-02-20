package com.laridosos.rest.treatmentMedicine.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.medicine.MedicineGetDTO;
import com.laridosos.rest.medicineApplication.dto.MedicineApplicationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
public class TreatmentMedicineCompleteGetDTO {
    private Long id;
    private Integer dosage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime beginHour;
    private Integer minutesInterval;
    private MedicineGetDTO medicine;
    private List<MedicineApplicationDTO> medicineApplications;

}
