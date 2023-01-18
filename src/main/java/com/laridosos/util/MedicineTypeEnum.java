package com.laridosos.util;

import lombok.Getter;

@Getter
public enum MedicineTypeEnum {
    COMPRIMIDO("Comprimido"),
    CAPSULA("Cápsula"),
    PASTILHA("Pastilha"),
    DRAGEA("Drágea"),
    GOTA("Gota"),
    SOLUCAO_ORAL("Solução oral"),
    POMADA("Pomada");

    private final String description;

    MedicineTypeEnum(String description) {
        this.description = description;
    }
}
