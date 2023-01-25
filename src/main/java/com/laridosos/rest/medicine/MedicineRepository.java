package com.laridosos.rest.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Page<Medicine> findAllByNameIgnoreCaseContaining(String name, Pageable pageable);
}
