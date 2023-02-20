package com.laridosos.rest.treatment;

import com.laridosos.rest.patient.Patient;
import com.laridosos.rest.patient.PatientMapper;
import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.treatment.dto.TreatmentGetWithoutPatientDTO;
import com.laridosos.rest.treatment.dto.TreatmentCompleteGetDTO;
import com.laridosos.rest.treatment.dto.TreatmentCreateDTO;
import com.laridosos.rest.treatment.dto.TreatmentGetDTO;
import com.laridosos.rest.treatmentMedicine.TreatmentMedicine;
import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TreatmentMapper {

    TreatmentMapper INSTANCE = getMapper(TreatmentMapper.class);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "disease.id", source = "diseaseId")
    @Mapping(target = "status", expression = "java(TreatmentStatus.IN_PROGRESS)")
    Treatment toCreateTreatment(TreatmentCreateDTO treatmentDTO);

    @Mapping(target = "medicine.id", source = "medicineId")
    TreatmentMedicine toTreatmentMedicine(TreatmentMedicineCreateDTO treatmentDTO);

    TreatmentGetDTO toTreatmentGetDTO(Treatment treatment);

    TreatmentCompleteGetDTO toTreatmentCompleteGetDTO(Treatment treatment);

    TreatmentGetWithoutPatientDTO toTreatmentGetWithoutPatientDTO(Treatment treatment);

    default PatientGetDTO toPatientGetDTO(Patient patient) {
        return PatientMapper.INSTANCE.toPatientGetDTO(patient);
    }
}
