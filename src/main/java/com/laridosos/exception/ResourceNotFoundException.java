package com.laridosos.exception;

public class ResourceNotFoundException extends RuntimeException {

    private final Long id;

    public ResourceNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
