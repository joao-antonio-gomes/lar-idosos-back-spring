package com.laridosos.rest.medicineApplication.service;

import com.laridosos.rest.medicineApplication.MedicineApplication;
import com.laridosos.rest.medicineApplication.MedicineApplicationRepository;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicineApplicationCreateServiceImplTest {

    @Mock
    private MedicineApplicationRepository repository;

    @Captor
    private ArgumentCaptor<Collection<MedicineApplication>> applicationsCaptor;

    private MedicineApplicationCreateServiceImpl service;

    @BeforeEach
    void setUp() {
        this.service = new MedicineApplicationCreateServiceImpl(repository);
    }

    @Test
    void shouldCreateApplications() {
        when(repository.saveAll(applicationsCaptor.capture())).thenReturn(new ArrayList<>());

        service.create(createTreatmentMedicine());

        Collection<MedicineApplication> applications = applicationsCaptor.getValue();
        assertEquals(5, applications.size());
    }

    private TreatmentMedicine createTreatmentMedicine() {
        return TreatmentMedicine.builder()
                .beginDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2023, 1, 3))
                .beginHour(LocalTime.of(12, 0))
                .minutesInterval(720)
                .build();
    }
}
