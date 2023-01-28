package com.laridosos.rest.user.dto;

import com.laridosos.rest.role.Role;
import com.laridosos.rest.user.UserApp;

import java.time.LocalDate;
import java.util.List;

public record UserGetDTO(
        Long id,
        String name,
        String cpf,
        String email,
        LocalDate birthDate,
        String gender,
        String maritalStatus,
        List<String> roles
) {

    public UserGetDTO(UserApp userApp) {
        this(
                userApp.getId(),
                userApp.getName(),
                userApp.getCpf(),
                userApp.getEmail(),
                userApp.getBirthDate(),
                userApp.getGender().name(),
                userApp.getMaritalStatus().name(),
                userApp.getRoles().stream().map(role -> role.getName().name()).toList()
        );
    }
}
