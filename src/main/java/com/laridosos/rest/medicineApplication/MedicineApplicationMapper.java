package com.laridosos.rest.medicineApplication;

import com.laridosos.rest.medicineApplication.dto.MedicineApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface MedicineApplicationMapper {

    MedicineApplicationMapper INSTANCE = getMapper(MedicineApplicationMapper.class);

    @Mapping(target = "treatmentId", source = "treatmentMedicine.id")
    MedicineApplicationDTO toDTO(MedicineApplication medicineApplication);
}
