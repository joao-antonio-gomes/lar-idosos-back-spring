package com.laridosos.rest.disease;

import com.laridosos.rest.disease.dto.DiseaseGetDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface DiseaseMapper {

    DiseaseMapper INSTANCE = getMapper(DiseaseMapper.class);

    DiseaseGetDTO toDiseaseGetDTO(Disease disease);
}
