package com.laridosos.rest.disease;

import com.laridosos.rest.disease.filter.DiseaseFilter;
import com.laridosos.rest.medicine.MedicineGetDTO;
import com.laridosos.rest.medicine.MedicineRepository;
import com.laridosos.rest.medicine.filter.MedicineFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diseases")
public class DiseaseController {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @GetMapping
    public ResponseEntity getAll(DiseaseFilter filter) {
        return ResponseEntity.ok(diseaseRepository.findAllByNameIgnoreCaseContaining(filter.getName(),
                                                           filter.toPageable())
                                                   .map(DiseaseMapper.INSTANCE::toDiseaseGetDTO));
    }
}
