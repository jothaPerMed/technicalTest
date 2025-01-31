package com.jgperea.technicalTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Output rest.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutputRest {
    /**
     * The Id producto.
     */
    private Long idProducto;
    /**
     * The Id cadena.
     */
    private Long idCadena;
    /**
     * The Tarifa aplicar.
     */
    private Long tarifaAplicar;
    /**
     * The Fecha entrada.
     */
    private LocalDateTime fechaEntrada;
    /**
     * The Fecha salida.
     */
    private LocalDateTime fechaSalida;
    /**
     * The Precio final aplicar.
     */
    private BigDecimal precioFinalAplicar;
}
