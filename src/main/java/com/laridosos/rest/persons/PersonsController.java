package com.laridosos.rest.persons;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    @GetMapping("/genders")
    public ResponseEntity getGenders() {
        return ResponseEntity.ok(Arrays.stream(GenderEnum.values()).map(EnumDTO::new));
    }
}
