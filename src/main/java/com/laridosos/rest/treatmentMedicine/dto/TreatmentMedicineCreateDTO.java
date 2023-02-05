package com.laridosos.rest.treatmentMedicine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentMedicineCreateDTO {
    private Long medicineId;
    private int dosage;
    private int minuteInterval;
    private LocalDate beginDate;
    private LocalDate endDate;
    private LocalTime beginHour;
}
