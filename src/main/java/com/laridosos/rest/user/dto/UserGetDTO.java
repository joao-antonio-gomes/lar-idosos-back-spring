package com.laridosos.rest.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class UserGetDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private String gender;
    private String maritalStatus;
    private List<String> roles;

}
