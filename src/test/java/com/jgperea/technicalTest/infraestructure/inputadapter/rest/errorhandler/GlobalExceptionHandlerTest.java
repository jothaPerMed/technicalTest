package com.jgperea.technicalTest.infraestructure.inputadapter.rest.errorhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jgperea.technicalTest.domain.exception.NotFoundException;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Global exception handler test.
 */
@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * Handler not found exception.
     *
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    void handlerNotFoundException() {
        assertEquals(globalExceptionHandler.handlerNotFoundException(new NotFoundException("test")).getBody(),
                ErrorDTO.builder().message("test").build());
        assertEquals(globalExceptionHandler.handlerNotFoundException(new NotFoundException("test")).getStatusCode(),
                HttpStatusCode.valueOf(404));
    }
}