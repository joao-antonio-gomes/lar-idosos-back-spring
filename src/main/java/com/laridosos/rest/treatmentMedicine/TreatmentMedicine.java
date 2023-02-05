package com.laridosos.rest.treatmentMedicine;

import com.laridosos.rest.medicine.Medicine;
import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.treatment.Treatment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Entity
@Table(name = "treatment_medicine")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreatmentMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer dosage;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "begin_hour")
    private LocalTime beginHour;

    @Column(name = "minutes_interval")
    private Integer minutesInterval;

    @ManyToOne
    private Treatment treatment;

    @ManyToOne
    private Medicine medicine;

    @OneToMany(mappedBy = "treatmentMedicine")
    private Collection<MedicineApplication> medicineApplications;
}
