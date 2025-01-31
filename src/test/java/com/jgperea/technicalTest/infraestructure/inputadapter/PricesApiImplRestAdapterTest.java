package com.jgperea.technicalTest.infraestructure.inputadapter;

import com.jgperea.technicalTest.application.input.PriceUseCase;
import com.jgperea.technicalTest.infraestructure.inputadapter.mapper.PriceRestMapper;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.PricesApiImplRestAdapter;
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
    private PriceUseCase priceUseCase;
    @Mock
    private PriceRestMapper priceRestMapper;
    @InjectMocks
    private PricesApiImplRestAdapter pricesApiImplRestAdapter;

    /**
     * Final price.
     */
    @Test
    void finalPrice() {
        when(priceRestMapper.toInputRest(any())).thenReturn(UtilTests.inputRest());
        when(priceRestMapper.toOutputDTO(any())).thenReturn(UtilTests.outputDTO());
        when(priceUseCase.pvpFinal(any())).thenReturn(UtilTests.outputRest());
        assertEquals(pricesApiImplRestAdapter.finalPrice(UtilTests.inputRestDTO()).getBody().getIdentificadorDeCadena().longValue(),
                EnumBrand.ZARA.branId.longValue());
        assertEquals(pricesApiImplRestAdapter.finalPrice(UtilTests.inputRestDTO()).getBody().getIdentificadorDeProducto().longValue(),
                EnumProduct.TEST.productId.longValue());
    }
}