package com.laridosos.rest.treatment;

import com.laridosos.rest.treatment.dto.TreatmentCreateDTO;
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

    @Mapping(source = "treatmentMedicines", target = "treatmentMedicines", qualifiedByName = "toTreatmentMedicines")
    Treatment toTreatment(TreatmentCreateDTO treatmentCreateDTO);

    @IterableMapping
    @Named("toTreatmentMedicines")
    default TreatmentMedicine toTreatmentMedicine(TreatmentMedicineCreateDTO treatmentMedicineCreateDTO) {
        return TreatmentMedicineMapper.INSTANCE.toTreatmentMedicine(treatmentMedicineCreateDTO);
    }
}
