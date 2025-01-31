package com.jgperea.technicalTest.infraestructure.inputadapter.rest.errorhandler;

import com.jgperea.technicalTest.domain.exception.NotFoundException;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handler not found exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatusCode.valueOf(404))
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorDTO.builder().message(e.getMessage()).build());
    }
}
