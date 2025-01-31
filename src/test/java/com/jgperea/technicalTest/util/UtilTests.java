package com.jgperea.technicalTest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgperea.technicalTest.domain.model.Brand;
import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.OutputRest;
import com.jgperea.technicalTest.domain.model.Prices;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.ErrorDTO;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.InputDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Util tests.
 */
public class UtilTests {
    /**
     * Gets body test 1.
     *
     * @return the body test 1
     */
    public static InputDTO getBodyTest1() {
        return InputDTO.builder()
                .fechaDeAplicacion("2020-06-14-10.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }

    /**
     * Gets body test 2.
     *
     * @return the body test 2
     */
    public static InputDTO getBodyTest2() {
        return InputDTO.builder()
                .fechaDeAplicacion("2020-06-14-16.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }

    /**
     * Gets body test 3.
     *
     * @return the body test 3
     */
    public static InputDTO getBodyTest3() {
        return InputDTO.builder()
                .fechaDeAplicacion("2020-06-14-21.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }

    /**
     * Gets body test 4.
     *
     * @return the body test 4
     */
    public static InputDTO getBodyTest4() {
        return InputDTO.builder()
                .fechaDeAplicacion("2020-06-15-10.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }

    /**
     * Gets body test 5.
     *
     * @return the body test 5
     */
    public static InputDTO getBodyTest5() {
        return InputDTO.builder()
                .fechaDeAplicacion("2020-06-16-21.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }


    /**
     * Gets body test not found.
     *
     * @return the body test not found
     */
    public static InputDTO getBodyTestNotFound() {
        return InputDTO.builder()
                .fechaDeAplicacion("2025-01-01-00.00.00")
                .identificadorDeCadena(new BigDecimal(1))
                .identificadorDeProducto(new BigDecimal(35455))
                .build();
    }


    /**
     * Expect test 1 double.
     *
     * @return the double
     */
    public static double expectTest1() {
        return 35.5;
    }

    /**
     * Expect test 2 double.
     *
     * @return the double
     */
    public static double expectTest2() {
        return 25.45;
    }

    /**
     * Expect test 3 double.
     *
     * @return the double
     */
    public static double expectTest3() {
        return 35.5;
    }

    /**
     * Expect test 4 double.
     *
     * @return the double
     */
    public static double expectTest4() {
        return 30.5;
    }

    /**
     * Expect test 5 double.
     *
     * @return the double
     */
    public static double expectTest5() {
        return 38.95;
    }

    /**
     * Expect exception test string.
     *
     * @return the string
     * @throws JsonProcessingException the json processing exception
     */
    public static String expectExceptionTest() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(
                ErrorDTO.builder().message(Constant.MESSAGE_ERROR_NOT_FOUND).build()
        );
    }

    /**
     * Gets pvp final.
     *
     * @return the pvp final
     */
    public static OutputRest getPvpFinal() {
        return OutputRest.builder()
                .idCadena(1L)
                .idProducto(1L)
                .fechaEntrada(LocalDateTime.now())
                .fechaSalida(LocalDateTime.now())
                .tarifaAplicar(1L)
                .precioFinalAplicar(new BigDecimal(1L))
                .build();
    }

    /**
     * Gets price final.
     *
     * @return the price final
     */
    public static Prices getPriceFinal() {
        return Prices.builder().brand(Brand.builder().brandId(1L).build()).build();
    }

    /**
     * Input rest input rest.
     *
     * @return the input rest
     */
    public static InputRest inputRest() {
        var fecha = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
        return InputRest.builder()
                .fechaEntrada(fecha)
                .idCadena(EnumBrand.ZARA.branId.longValue())
                .idProducto(35455L)
                .build();
    }

    /**
     * Output rest output rest.
     *
     * @return the output rest
     */
    public static OutputRest outputRest() {
        var fecha = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
        return OutputRest.builder()
                .fechaEntrada(fecha)
                .fechaSalida(fecha)
                .idCadena(EnumBrand.ZARA.branId.longValue())
                .idProducto(35455L)
                .tarifaAplicar(1L)
                .precioFinalAplicar(new BigDecimal(1))
                .build();
    }
}
