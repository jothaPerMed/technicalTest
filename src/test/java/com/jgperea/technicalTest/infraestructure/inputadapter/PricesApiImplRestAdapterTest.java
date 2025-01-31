package com.jgperea.technicalTest.infraestructure.inputadapter;

import com.jgperea.technicalTest.application.usecase.PriceUseCaseImpl;
import com.jgperea.technicalTest.domain.mapper.PriceDomainMapper;
import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.infraestructure.outputadapter.integration.PriceOutputIntegrationAdapter;
import com.jgperea.technicalTest.util.EnumBrand;
import com.jgperea.technicalTest.util.EnumProduct;
import com.jgperea.technicalTest.util.UtilTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * The type Prices api impl rest adapter test.
 */
@ExtendWith(MockitoExtension.class)
class PricesApiImplRestAdapterTest {
    @Mock
    private PriceOutputIntegrationAdapter priceOutputIntegrationAdapter;
    @Mock
    private PriceDomainMapper priceDomainMapper;
    @InjectMocks
    private PriceUseCaseImpl priceUseCase;

    /**
     * Pvp final.
     */
    @Test
    void pvpFinal() {
        var inputTest = InputRest.builder().build();
        when(priceDomainMapper.toOutputRest(any())).thenReturn(UtilTests.getPvpFinal());
        when(priceOutputIntegrationAdapter.pvpFinal(any())).thenReturn(UtilTests.getPriceFinal());
        assertEquals(priceUseCase.pvpFinal(inputTest).getIdCadena(), EnumBrand.ZARA.branId.longValue());
        assertEquals(priceUseCase.pvpFinal(inputTest).getIdProducto(), EnumProduct.TEST.productId.longValue());
    }
}