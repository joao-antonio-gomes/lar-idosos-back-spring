package com.laridosos.rest.patient;

import com.laridosos.rest.patient.dto.PatientGetDTO;
import com.laridosos.rest.patient.dto.PatientPatchDTO;
import com.laridosos.rest.patient.dto.PatientPostDTO;
import com.laridosos.rest.user.UserApp;
import com.laridosos.rest.user.UserMapper;
import com.laridosos.rest.user.dto.UserGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = getMapper(PatientMapper.class);

    @Mapping(target = "responsible", source = "responsible", qualifiedByName = "toUserGetDTO")
    PatientGetDTO toPatientGetDTO(Patient patient);

    @Mapping(target = "responsible", source = "responsible", qualifiedByName = "toUser")
    Patient toPatient(PatientPatchDTO patientGetDTO);

    @Mapping(target = "responsible", source = "responsible", qualifiedByName = "toUser")
    Patient toPatient(PatientPostDTO patient);

    @Named("toUserGetDTO")
    default UserGetDTO toUserGetDTO(UserApp user) {
        return UserMapper.INSTANCE.toUserGetDTO(user);
    }

    @Named("toUser")
    default UserApp toUser(UserGetDTO user) {
        return UserMapper.INSTANCE.toUser(user);
    }
}
