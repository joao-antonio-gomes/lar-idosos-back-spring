package com.laridosos.rest.patient;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping
    public ResponseEntity getAll(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable).map(PatientGetDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientById(@PathVariable Long id, HttpServletRequest request) {
        Optional<Patient> patient = repository.findById(id);

        if (patient.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        return ResponseEntity.ok(new PatientGetDTO(patient.get()));
    }
}
