package com.laridosos.rest.user;

import com.laridosos.rest.role.Role;
import com.laridosos.rest.role.RoleEnum;
import com.laridosos.rest.user.dto.UserGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = getMapper(UserMapper.class);

    @Mapping(target = "roles", expression = "java(user.getRolesStringList())")
    UserGetDTO toUserGetDTO(UserApp user);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "toRoles")
    UserApp toUser(UserGetDTO user);

    @Named("toRoles")
    default List<Role> toRoles(List<String> roles) {
        if (roles == null) {
            return new ArrayList<>();
        }
        return roles.stream()
                    .map(role -> new Role(
                            (long) RoleEnum.valueOf(role)
                                           .ordinal(),
                            RoleEnum.valueOf(role)))
                    .collect(Collectors.toList());
    }
}
