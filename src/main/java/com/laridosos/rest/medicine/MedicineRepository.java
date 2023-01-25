package com.laridosos.rest.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query("SELECT p FROM Medicine p WHERE (:name is null or LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    Page<Medicine> findAllByNameIgnoreCaseContaining(String name, Pageable pageable);
}
