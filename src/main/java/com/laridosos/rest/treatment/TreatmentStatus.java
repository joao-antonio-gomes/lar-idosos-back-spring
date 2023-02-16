package com.laridosos.rest.treatment;

public enum TreatmentStatus {
    IN_PROGRESS("Em andamento"),
    FINISHED("Finalizado"),
    CANCELED("Cancelado"),
    PENDING("Pendente");

    private final String description;

    TreatmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
