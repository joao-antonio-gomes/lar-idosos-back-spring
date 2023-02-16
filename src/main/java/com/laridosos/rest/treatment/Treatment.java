package com.laridosos.rest.treatment;

import com.laridosos.rest.disease.Disease;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TreatmentStatus status = TreatmentStatus.IN_PROGRESS;

    @ManyToOne
    private Disease disease;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "treatment")
    private Collection<TreatmentMedicine> treatmentMedicines;
}
