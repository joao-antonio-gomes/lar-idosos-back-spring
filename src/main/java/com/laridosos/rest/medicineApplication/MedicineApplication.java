package com.laridosos.rest.medicineApplication;


import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "medicine_application")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MedicineApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;
    private LocalTime hour;
    @Column(name = "is_applied")
    private boolean applied;
    private String observation;

    @ManyToOne
    @JoinColumn(name = "treatment_medicine_id")
    private TreatmentMedicine treatmentMedicine;
}
