package com.laridosos.rest.treatment;

import com.laridosos.rest.disease.Disease;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="begin_date")
    private LocalDate beginDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "treatments_diseases",
            joinColumns = @JoinColumn(
                    name = "treatment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "disease_id", referencedColumnName = "id"))
    private Collection<Disease> diseases;
}
