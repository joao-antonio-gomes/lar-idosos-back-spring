package com.laridosos.config;

import com.laridosos.exception.ApplicationException;
import com.laridosos.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandle {

    Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    private record ErrorMessageDTO(Integer status, String mensagem) {

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage());

        logger.error(exception.getMessage(), exception);

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

        logger.error(exception.getMessage(), exception);
        //TODO refazer forma de disponibilizar erro
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                             .body(fieldErrors.stream()
                                              .map(CamposInvalidosDTO::new)
                                              .toList());
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity handleApplicationException(ApplicationException exception) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.BAD_REQUEST.value(), exception.getMessage());

        logger.error(exception.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                             .body(errorMessageDTO);
    }
}
