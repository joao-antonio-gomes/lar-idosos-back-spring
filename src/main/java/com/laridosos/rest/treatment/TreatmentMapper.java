package com.laridosos.rest.treatment;

import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.PatientMapper;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.treatment.dto.TreatmentCreateDTO;
import com.laridosos.rest.treatment.dto.TreatmentGetDTO;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicineMapper;
import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCreateDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TreatmentMapper {

    TreatmentMapper INSTANCE = getMapper(TreatmentMapper.class);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "disease.id", source = "diseaseId")
    Treatment toTreatment(TreatmentCreateDTO treatmentDTO);

    @Mapping(target = "medicine.id", source = "medicineId")
    TreatmentMedicine toTreatmentMedicine(TreatmentMedicineCreateDTO treatmentDTO);

    TreatmentGetDTO toTreatmentGetDTO(Treatment treatment);

    default PatientGetDTO toPatientGetDTO(Patient patient) {
        return PatientMapper.INSTANCE.toPatientGetDTO(patient);
    }
}
