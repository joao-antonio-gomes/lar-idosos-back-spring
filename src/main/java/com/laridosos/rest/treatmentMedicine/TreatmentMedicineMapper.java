package com.laridosos.rest.treatmentMedicine;

import com.laridosos.rest.treatmentMedicine.dto.TreatmentMedicineCreateDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TreatmentMedicineMapper {

    TreatmentMedicineMapper INSTANCE = getMapper(TreatmentMedicineMapper.class);

    TreatmentMedicine toTreatmentMedicine(TreatmentMedicineCreateDTO treatmentMedicineCreateDTO);
}
