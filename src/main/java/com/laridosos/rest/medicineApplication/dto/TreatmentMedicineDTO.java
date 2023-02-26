package com.laridosos.rest.medicineApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laridosos.rest.medicine.MedicineGetDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class TreatmentMedicineDTO {
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
    private TreatmentDTO treatment;
}
