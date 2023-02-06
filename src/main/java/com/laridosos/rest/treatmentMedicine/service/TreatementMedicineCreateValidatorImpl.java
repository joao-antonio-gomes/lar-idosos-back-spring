package com.laridosos.rest.treatmentMedicine.service;

import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import org.springframework.stereotype.Service;

@Service
public class TreatementMedicineCreateValidatorImpl implements TreatementMedicineCreateValidator {

    @Override
    public void validate(TreatmentMedicine treatmentMedicine) {
        validateObrigatoryFields(treatmentMedicine);
        validateBeginDateIsBeforeEndDate(treatmentMedicine);
        validateDosageIsGreaterThanZero(treatmentMedicine);
        validaIntervalIsGreaterThanZero(treatmentMedicine);
    }

    private void validateObrigatoryFields(TreatmentMedicine treatmentMedicine) {
        if (treatmentMedicine.getMedicine() == null || treatmentMedicine.getMedicine().getId() == null) {
            throw new IllegalArgumentException("Medicamento é obrigatório");
        }

        if (treatmentMedicine.getTreatment() == null || treatmentMedicine.getTreatment().getId() == null) {
            throw new IllegalArgumentException("Tratamento é obrigatório");
        }

        if (treatmentMedicine.getBeginDate() == null) {
            throw new IllegalArgumentException("Data de início aplicação do medicamento é obrigatório");
        }

        if (treatmentMedicine.getEndDate() == null) {
            throw new IllegalArgumentException("Data de fim da aplicação do medicamento é obrigatório");
        }

        if (treatmentMedicine.getMinutesInterval() == null) {
            throw new IllegalArgumentException("Intervalo de tempo entre as aplicações do medicamento é obrigatório");
        }

        if (treatmentMedicine.getDosage() == null) {
            throw new IllegalArgumentException("Dosagem do medicamento é obrigatório");
        }
    }

    private void validateBeginDateIsBeforeEndDate(TreatmentMedicine treatmentMedicine) {
        if (treatmentMedicine.getBeginDate().isAfter(treatmentMedicine.getEndDate())) {
            throw new IllegalArgumentException("Data de início aplicação do medicamento não pode ser maior que a data de fim da aplicação do medicamento");
        }
    }

    private void validateDosageIsGreaterThanZero(TreatmentMedicine treatmentMedicine) {
        if (treatmentMedicine.getDosage() <= 0) {
            throw new IllegalArgumentException("Dosagem deve ser maior que zero");
        }
    }

    private void validaIntervalIsGreaterThanZero(TreatmentMedicine treatmentMedicine) {
        if (treatmentMedicine.getMinutesInterval() <= 0) {
            throw new IllegalArgumentException("Intervalo de tempo entre as aplicações do medicamento deve ser maior que zero");
        }
    }
}
