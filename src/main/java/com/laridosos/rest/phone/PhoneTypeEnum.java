package com.laridosos.rest.phone;

import lombok.Getter;

@Getter
public enum PhoneTypeEnum {
    TELEFONE_FIXO("Telefone fixo"),
    CELULAR("Celular");

    private final String description;

    PhoneTypeEnum(String description) {
        this.description = description;
    }
}
