package com.laridosos.rest.disease.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DiseaseGetDTO {
    private final Long id;
    private final String name;
    private final String observation;
    private final String symptoms;
}
