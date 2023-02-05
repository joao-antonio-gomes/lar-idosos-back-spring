package com.laridosos.rest.disease;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    @Query("SELECT d FROM Disease d WHERE (:name is null or LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    Page<Disease> findAllByNameIgnoreCaseContaining(String name, Pageable pageable);
}
