package com.laridosos.rest.persons;

public record EnumDTO(String label, String value) {

    public EnumDTO(GenderEnum genderEnum) {
        this(genderEnum.getDescription(), genderEnum.name());
    }

    public EnumDTO(MaritalStatusEnum maritalStatusEnum) {
        this(maritalStatusEnum.name(), maritalStatusEnum.getDescription());
    }
}
