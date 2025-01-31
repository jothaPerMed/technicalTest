package com.jgperea.technicalTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Input rest.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputRest {
    /**
     * The Fecha entrada.
     */
    private LocalDateTime fechaEntrada;
    /**
     * The Id producto.
     */
    private Long idProducto;
    /**
     * The Id cadena.
     */
    private Long idCadena;
}
