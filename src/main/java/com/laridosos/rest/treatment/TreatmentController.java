package com.laridosos.rest.treatment;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.treatment.dto.TreatmentCompleteGetDTO;
import com.laridosos.rest.treatment.dto.TreatmentCreateDTO;
import com.laridosos.rest.treatment.dto.TreatmentGetDTO;
import com.laridosos.rest.treatment.service.TreatmentCreateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentCreateService treatmentCreateService;

    @Autowired
    private TreatmentRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<TreatmentGetDTO> create(@RequestBody TreatmentCreateDTO treatment, HttpServletRequest request) {
        Treatment treatmentCreated = treatmentCreateService.create(TreatmentMapper.INSTANCE.toCreateTreatment(treatment));

        URI uri = URI.create(request.getRequestURL()
                                    .toString() + "/" + treatmentCreated.getId());
        return ResponseEntity.created(uri).body(TreatmentMapper.INSTANCE.toTreatmentGetDTO(treatmentCreated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentCompleteGetDTO> getTreatmentById(@PathVariable Long id, HttpServletRequest request) {
        Optional<Treatment> treatment = repository.findById(id);

        if (treatment.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        return ResponseEntity.ok(TreatmentMapper.INSTANCE.toTreatmentCompleteGetDTO(treatment.get()));
    }
}
