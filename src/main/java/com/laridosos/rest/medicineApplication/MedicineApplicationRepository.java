package com.laridosos.rest.medicineApplication;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface MedicineApplicationRepository extends JpaRepository<MedicineApplication, Long> {

    @Query("SELECT ma FROM MedicineApplication ma WHERE ma.applied = false AND ma.date <= :date AND (ma.date < :date OR ma.hour < :hour) ORDER BY ma.date DESC, ma.hour DESC")
    Page<MedicineApplication> findLatedMedicineApplication(LocalDate date, LocalTime hour, Pageable pageable);

    @Query("SELECT ma FROM MedicineApplication ma WHERE ma.applied = false AND ma.date >= :date AND (ma.date > :date OR ma.hour > :hour) ORDER BY ma.date DESC, ma.hour DESC")
    Page<MedicineApplication> findToBeAppliedMedicineApplication(LocalDate date, LocalTime hour, Pageable pageable);

    @Query("SELECT ma FROM MedicineApplication ma WHERE ma.applied = true AND ma.date <= :date AND (ma.date < :date OR ma.hour < :hour) ORDER BY ma.date DESC, ma.hour DESC")
    Page<MedicineApplication> findReleasedMedicineApplication(LocalDate date, LocalTime hour, Pageable pageable);
}
