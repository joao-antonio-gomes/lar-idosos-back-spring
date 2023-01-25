package com.laridosos.rest.medicine;

import com.laridosos.rest.medicine.filter.MedicineFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping
    public ResponseEntity getAll(MedicineFilter medicineFilter) {
        return ResponseEntity.ok(medicineRepository.findAllByNameIgnoreCaseContaining(medicineFilter.getName(),
                                                           medicineFilter.toPageable())
                                                   .map(MedicineGetDTO::new));
    }
}
