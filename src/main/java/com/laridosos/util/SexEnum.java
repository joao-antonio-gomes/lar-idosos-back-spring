package com.laridosos.util;

import lombok.Getter;

@Getter
public enum SexEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String description;

    SexEnum(String description) {
        this.description = description;
    }
}
