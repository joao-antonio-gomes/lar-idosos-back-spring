package com.laridosos.rest.patient;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.patient.dto.PatientPatchDTO;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.patient.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientService patientService;

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

    @PatchMapping("/{id}")
    public ResponseEntity patch(@RequestBody PatientPatchDTO patientRequestData, @PathVariable Long id, HttpServletRequest request) {
        Optional<Patient> patient = repository.findById(id);

        if (patient.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        Patient patientUpdated = patientService.patch(patient.get(), patientRequestData.toPatient());

        return ResponseEntity.ok(new PatientGetDTO(patientUpdated));
    }
}
