package com.laridosos.rest.patient.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientFilter {

    private String name;

    private String sort = "name";
    private int page = 0;
    private int size = 10;

    public Pageable toPageable() {
        return PageRequest.of(page, size, Sort.by(sort).ascending());
    }
}
