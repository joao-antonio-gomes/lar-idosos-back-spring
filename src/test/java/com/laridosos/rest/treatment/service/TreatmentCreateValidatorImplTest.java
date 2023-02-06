package com.laridosos.rest.treatment.service;

import com.laridosos.exception.ApplicationException;
import com.laridosos.rest.disease.Disease;
import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.treatment.Treatment;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreatmentCreateValidatorImplTest {

    private TreatmentCreateValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new TreatmentCreateValidatorImpl();
    }

    @Test
    public void shouldThrowError_whenBeginDate_isNull() {
        Treatment treatment = createTreatment();
        treatment.setBeginDate(null);

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A data de início do tratamento é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenEndDate_isNull() {
        Treatment treatment = createTreatment();
        treatment.setEndDate(null);

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A data de fim do tratamento é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenDisease_isNull() {
        Treatment treatment = createTreatment();
        treatment.setDisease(null);

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A doença é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenDiseaseId_isNull() {
        Treatment treatment = createTreatment();
        treatment.setDisease(new Disease());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A doença é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenPatient_isNull() {
        Treatment treatment = createTreatment();
        treatment.setPatient(null);

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("O paciente é obrigatório", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenPatientId_isNull() {
        Treatment treatment = createTreatment();
        treatment.setPatient(new Patient());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("O paciente é obrigatório", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenTreatmentMedicines_isNull() {
        Treatment treatment = createTreatment();
        treatment.setTreatmentMedicines(null);

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A lista de medicamentos é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenTreatmentMedicines_isEmpty() {
        Treatment treatment = createTreatment();
        treatment.setTreatmentMedicines(List.of());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A lista de medicamentos é obrigatória", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenBeginDateMedicine_isBeforeBeginDateTreatment() {
        Treatment treatment = createTreatment();
        treatment.setBeginDate(LocalDate.of(2020, 1, 6));
        treatment.setTreatmentMedicines(List.of(createTreatmentMedicine()));

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A data de início da aplicação do medicamento deve ser posterior a data de início do tratamento", exception.getMessage());
    }

    @Test
    public void shouldThrowError_whenEndDateMedicine_isAfterEndDateTreatment() {
        Treatment treatment = createTreatment();
        treatment.setBeginDate(LocalDate.of(2020, 1, 5));
        treatment.setEndDate(LocalDate.of(2020, 1, 6));
        treatment.setTreatmentMedicines(List.of(createTreatmentMedicine()));

        ApplicationException exception = assertThrows(ApplicationException.class, () -> validator.validate(treatment));
        assertEquals("A data de fim da aplicação do medicamento deve ser anterior a data de fim do tratamento", exception.getMessage());
    }

    private Treatment createTreatment() {
        return Treatment.builder()
                        .disease(createDisease())
                        .patient(createPatient())
                        .beginDate(LocalDate.of(2020, 1, 5))
                        .endDate(LocalDate.of(2020, 1, 10))
                        .treatmentMedicines(List.of(createTreatmentMedicine()))
                        .build();
    }

    private TreatmentMedicine createTreatmentMedicine() {
        return TreatmentMedicine.builder()
                                .beginDate(LocalDate.of(2020, 1, 5))
                                .endDate(LocalDate.of(2020, 1, 10))
                                .build();
    }

    private Patient createPatient() {
        return Patient.builder()
                      .id(1L)
                      .build();
    }

    private Disease createDisease() {
        return Disease.builder()
                      .id(1L)
                      .build();
    }

}
