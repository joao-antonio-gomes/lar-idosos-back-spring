package com.laridosos.rest.persons;

import lombok.Getter;

@Getter
public enum GenderEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String description;

    GenderEnum(String description) {
        this.description = description;
    }
}
