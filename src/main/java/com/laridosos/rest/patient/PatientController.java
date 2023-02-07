package com.laridosos.rest.patient;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.patient.dto.PatientPatchDTO;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.patient.dto.PatientPostDTO;
import com.laridosos.rest.patient.filter.PatientFilter;
import com.laridosos.rest.patient.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity getAll(PatientFilter filter) {
        Pageable pageable = filter.toPageable();
        return ResponseEntity.ok(repository.findAllByNameIgnoreCaseContaining(filter.getName(), pageable).map(PatientMapper.INSTANCE::toPatientGetDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientById(@PathVariable Long id, HttpServletRequest request) {
        Optional<Patient> patient = repository.findById(id);

        if (patient.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        return ResponseEntity.ok(PatientMapper.INSTANCE.toPatientGetDTO(patient.get()));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PatientPostDTO patient, HttpServletRequest request) {
        Patient patientCreated = patientService.save(PatientMapper.INSTANCE.toPatient(patient));

        URI uri = URI.create(request.getRequestURL()
                                    .toString() + "/" + patientCreated.getId());
        return ResponseEntity.created(uri).body(PatientMapper.INSTANCE.toPatientGetDTO(patientCreated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@RequestBody PatientPatchDTO patientRequestData, @PathVariable Long id, HttpServletRequest request) {
        Optional<Patient> patient = repository.findById(id);

        if (patient.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        Patient patientUpdated = patientService.patch(patient.get(), PatientMapper.INSTANCE.toPatient(patientRequestData));

        return ResponseEntity.ok(PatientMapper.INSTANCE.toPatientGetDTO(patientUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id, HttpServletRequest request) {
        Optional<Patient> patient = repository.findById(Long.parseLong(id));

        if (patient.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        repository.delete(patient.get());

        return ResponseEntity.noContent().build();
    }
}
