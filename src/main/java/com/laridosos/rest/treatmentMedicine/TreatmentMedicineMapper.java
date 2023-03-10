package com.laridosos.rest.treatmentMedicine;

import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TreatmentMedicineMapper {

    TreatmentMedicineMapper INSTANCE = getMapper(TreatmentMedicineMapper.class);


    @Mapping(target = "medicine.id", source = "medicineId")
    TreatmentMedicine toTreatmentMedicine(TreatmentMedicineCreateDTO treatmentMedicineCreateDTO);
}
