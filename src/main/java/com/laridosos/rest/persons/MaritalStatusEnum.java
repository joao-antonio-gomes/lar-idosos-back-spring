package com.laridosos.rest.persons;

import lombok.Getter;

@Getter
public enum MaritalStatusEnum {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)");

    private final String description;

    MaritalStatusEnum(String description) {
        this.description = description;
    }
}
