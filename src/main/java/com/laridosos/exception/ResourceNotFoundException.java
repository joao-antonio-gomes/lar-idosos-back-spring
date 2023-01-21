package com.laridosos.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String mensagem;

    public ResourceNotFoundException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return String.format("Recurso não encontrado em '%s'", mensagem);
    }
}
