package com.laridosos.rest.treatment.service;

import com.laridosos.exception.ApplicationException;
import com.laridosos.rest.treatment.Treatment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TreatmentCreateValidatorImpl implements TreatmentCreateValidator {

    @Override
    public void validate(Treatment treatment) {
        validateObrigatoryFields(treatment);
        validateTreatmentDates(treatment);
    }

    private void validateObrigatoryFields(Treatment treatment) {
        if (treatment.getBeginDate() == null) {
            throw new ApplicationException("A data de início do tratamento é obrigatória");
        }

        if (treatment.getEndDate() == null) {
            throw new ApplicationException("A data de fim do tratamento é obrigatória");
        }

        if (treatment.getDisease() == null || treatment.getDisease().getId() == null) {
            throw new ApplicationException("A doença é obrigatória");
        }

        if (treatment.getPatient() == null || treatment.getPatient().getId()== null) {
            throw new ApplicationException("O paciente é obrigatório");
        }

        if (treatment.getTreatmentMedicines() == null || treatment.getTreatmentMedicines().isEmpty()) {
            throw new ApplicationException("A lista de medicamentos é obrigatória");
        }
    }

    private void validateTreatmentDates(Treatment treatment) {
        LocalDate beginDate = treatment.getBeginDate();
        LocalDate endDate = treatment.getEndDate();

        treatment.getTreatmentMedicines()
                 .forEach(treatMedicine -> {
                     if (treatMedicine.getBeginDate()
                                      .isBefore(beginDate)) {
                         throw new ApplicationException("A data de início da aplicação do medicamento deve ser posterior a data de início do tratamento");
                     }

                     if (treatMedicine.getEndDate()
                                      .isAfter(endDate)) {
                         throw new ApplicationException("A data de fim da aplicação do medicamento deve ser anterior a data de fim do tratamento");
                     }
                 });
    }
}
