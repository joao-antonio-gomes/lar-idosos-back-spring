package com.laridosos.rest.medicineApplication;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.medicineApplication.dto.MedicineApplicationDTO;
import com.laridosos.rest.medicineApplication.service.MedicineApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/medicine-applications")
public class MedicineApplicationController {

    @Autowired
    private MedicineApplicationService medicineApplicationService;

    @GetMapping
    public ResponseEntity getMedicineApplications() {
        List<MedicineApplication> medApplications = medicineApplicationService.findAll();
        return ResponseEntity.ok(medApplications.stream().map(MedicineApplicationMapper.INSTANCE::toDTO));
    }

    @GetMapping("/by-status")
    @Cacheable("medicineApplicationsByStatusApplied")
    public ResponseEntity getMedicineApplicationsByStatusApplied() {
        Map<String, List<MedicineApplication>> medApplications = medicineApplicationService.findAllByStatusApplied();
        return ResponseEntity.ok(convertToDTO(medApplications));
    }

    private Map<String, List<MedicineApplicationDTO>> convertToDTO(Map<String, List<MedicineApplication>> medApplications) {
        Map<String, List<MedicineApplicationDTO>> medApplicationsDTO = new HashMap<>();
        for (Map.Entry<String, List<MedicineApplication>> entry : medApplications.entrySet()) {
            medApplicationsDTO.put(entry.getKey(), entry.getValue().stream().map(MedicineApplicationMapper.INSTANCE::toDTO).toList());
        }
        return medApplicationsDTO;
    }

    @PatchMapping("/{applicationId}/apply")
    public ResponseEntity applyMedicineApplication(@PathVariable Long applicationId, HttpServletRequest request) {
        Optional<MedicineApplication> medicineApplication = medicineApplicationService.findById(applicationId);

        if (medicineApplication.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        medicineApplicationService.applyMedicineApplication(medicineApplication.get());

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{applicationId}/unapply")
    public ResponseEntity unapplyMedicineApplication(@PathVariable Long applicationId, HttpServletRequest request) {
        Optional<MedicineApplication> medicineApplication = medicineApplicationService.findById(applicationId);

        if (medicineApplication.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        medicineApplicationService.unapplyMedicineApplication(medicineApplication.get());

        return ResponseEntity.ok().build();
    }
}
