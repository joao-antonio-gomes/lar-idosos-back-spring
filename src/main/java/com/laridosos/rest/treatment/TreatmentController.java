package com.laridosos.rest.treatment;

import com.laridosos.rest.treatment.dto.TreatmentCreateDTO;
import com.laridosos.rest.treatment.service.TreatmentCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentCreateService treatmentCreateService;

    @PostMapping
    public void create(@RequestBody TreatmentCreateDTO treatment) {
        Treatment treatmentCreated = treatmentCreateService.create(TreatmentMapper.INSTANCE.toTreatment(treatment));
    }
}
