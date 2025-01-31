package com.jgperea.technicalTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.PricesApiImplRestAdapter;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.InputDTO;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.OutputDTO;
import com.jgperea.technicalTest.util.Constant;
import com.jgperea.technicalTest.util.EnumBrand;
import com.jgperea.technicalTest.util.UtilTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Technical test application tests.
 */
@AutoConfigureMockMvc
@SpringBootTest
class TechnicalTestApplicationTests {

    @Autowired
    private PricesApiImplRestAdapter controller;
    /**
     * The Mock mvc.
     */
    @Autowired
    MockMvc mockMvc;


    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    /**
     * Test 1.
     *
     * @throws Exception the exception
     */
    @Test
    void test1() throws Exception {
        setPerform(setBody(UtilTests.getBodyTest1())).andExpect(status().isOk())
                .andExpectAll(result -> {
                    var output = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                            OutputDTO.class);
                    assertEquals(output.getIdentificadorDeCadena(), EnumBrand.ZARA.branId);
                    assertEquals(output.getPrecioFinalAplicar().doubleValue(), UtilTests.expectTest1());
                });
    }

    /**
     * Sets body.
     *
     * @param dto the body test 4
     * @return the body
     * @throws JsonProcessingException the json processing exception
     */
    private String setBody(InputDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }

    /**
     * Test 2.
     *
     * @throws Exception the exception
     */
    @Test
    void test2() throws Exception {
        setPerform(setBody(UtilTests.getBodyTest2())).andExpect(status().isOk())
                .andExpectAll(result -> {
                    var output = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                            OutputDTO.class);
                    assertEquals(output.getIdentificadorDeCadena(), EnumBrand.ZARA.branId);
                    assertEquals(output.getPrecioFinalAplicar().doubleValue(), UtilTests.expectTest2());
                });
    }

    /**
     * Test 3.
     *
     * @throws Exception the exception
     */
    @Test
    void test3() throws Exception {
        setPerform(setBody(UtilTests.getBodyTest3())).andExpect(status().isOk())
                .andExpectAll(result -> {
                    var output = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                            OutputDTO.class);
                    assertEquals(output.getIdentificadorDeCadena(), EnumBrand.ZARA.branId);
                    assertEquals(output.getPrecioFinalAplicar().doubleValue(), UtilTests.expectTest3());
                });
    }

    /**
     * Test 4.
     *
     * @throws Exception the exception
     */
    @Test
    void test4() throws Exception {
        setPerform(setBody(UtilTests.getBodyTest4())).andExpect(status().isOk())
                .andExpect(result -> {
                    var output = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                            OutputDTO.class);
                    assertEquals(output.getIdentificadorDeCadena(), EnumBrand.ZARA.branId);
                    assertEquals(output.getPrecioFinalAplicar().doubleValue(), UtilTests.expectTest4());

                });
    }

    /**
     * Test 5.
     *
     * @throws Exception the exception
     */
    @Test
    void test5() throws Exception {
        setPerform(setBody(UtilTests.getBodyTest5())).andExpect(status().isOk())
                .andExpectAll(result -> {
                    var output = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                            OutputDTO.class);
                    assertEquals(output.getIdentificadorDeCadena(), EnumBrand.ZARA.branId);
                    assertEquals(output.getPrecioFinalAplicar().doubleValue(), UtilTests.expectTest5());
                });
    }

    /**
     * Test not found.
     *
     * @throws Exception the exception
     */
    @Test
    void testNotFound() throws Exception {
        setPerform(setBody(UtilTests.getBodyTestNotFound()))
                .andExpect(status().isNotFound()).andExpect(result ->
                        assertEquals(
                                result.getResponse().getContentAsString(),
                                UtilTests.expectExceptionTest()
                        ));

    }


    /**
     * Sets perform.
     *
     * @param content the content
     * @return the perform
     * @throws Exception the exception
     */
    private ResultActions setPerform(String content) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(Constant.ENDPOINT_PRICES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        );
    }
}
