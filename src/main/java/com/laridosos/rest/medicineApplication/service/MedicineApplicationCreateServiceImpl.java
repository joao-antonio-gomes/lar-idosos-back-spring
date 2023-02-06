package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.medicineApplication.MedicineApplicationRepository;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MedicineApplicationCreateServiceImpl implements MedicineApplicationCreateService {

    private final MedicineApplicationRepository repository;

    public MedicineApplicationCreateServiceImpl(MedicineApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<MedicineApplication> create(TreatmentMedicine treatment) {
        LocalDateTime treatmentEndDateTime = LocalDateTime.of(treatment.getEndDate(), treatment.getBeginHour());
        LocalDateTime applicationDateTime = LocalDateTime.of(treatment.getBeginDate(), treatment.getBeginHour());
        Integer minutesInterval = treatment.getMinutesInterval();

        Collection<MedicineApplication> applications = new ArrayList<>();

        while (treatmentEndDateTime.isAfter(applicationDateTime) || treatmentEndDateTime.isEqual(applicationDateTime)) {
            MedicineApplication medicineApplication = MedicineApplication.builder()
                                                                         .treatmentMedicine(treatment)
                                                                         .date(applicationDateTime.toLocalDate())
                                                                         .hour(applicationDateTime.toLocalTime())
                                                                         .isApplied(false)
                                                                         .build();

            applications.add(medicineApplication);

            applicationDateTime = applicationDateTime.plusMinutes(minutesInterval);
        }

        return repository.saveAll(applications);
    }
}
