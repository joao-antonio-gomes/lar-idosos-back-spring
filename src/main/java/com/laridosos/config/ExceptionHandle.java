package com.laridosos.config;

import com.laridosos.exception.ResourceNotFoundException;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandle {

    private record ErrorMessageDTO(Integer status, String mensagem) {

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception) {

        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                             .body(errorMessageDTO);
    }

    private record CamposInvalidosDTO(String campo, String mensagem) {
        public CamposInvalidosDTO(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record ErrorMessageListDTO(Integer status, List<CamposInvalidosDTO> erros) {

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleUnprocessableEntityException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                             .body(fieldErrors.stream()
                                              .map(CamposInvalidosDTO::new)
                                              .toList());
    }
}
