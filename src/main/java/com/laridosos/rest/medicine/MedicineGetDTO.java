package com.laridosos.rest.medicine;

public record MedicineGetDTO(
        Long id,
        String name,
        String description,
        Integer concentration,
        String type,
        Integer stockQuantity
) {

    public MedicineGetDTO(Medicine medicine) {
        this(
                medicine.getId(),
                medicine.getName(),
                medicine.getDescription(),
                medicine.getConcentration(),
                medicine.getType().getDescription(),
                medicine.getStockQuantity()
        );
    }
}
