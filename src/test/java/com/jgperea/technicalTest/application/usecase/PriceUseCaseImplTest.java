package com.jgperea.technicalTest.application.usecase;

import com.jgperea.technicalTest.domain.mapper.PriceDomainMapper;
import com.jgperea.technicalTest.infraestructure.outputadapter.integration.PriceOutputIntegrationAdapter;
import com.jgperea.technicalTest.util.UtilTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseImplTest {
    @Mock
    private PriceOutputIntegrationAdapter priceOutputIntegrationAdapter;
    @Mock
    private PriceDomainMapper priceDomainMapper;
    @InjectMocks
    private PriceUseCaseImpl priceUseCase;

    @Test
    void pvpFinal() {
        Mockito.when(priceDomainMapper.toOutputRest(any())).thenReturn(UtilTests.outputRest());
        Mockito.when(priceOutputIntegrationAdapter.pvpFinal(any())).thenReturn(UtilTests.getPriceFinal());
        assertEquals(priceUseCase.pvpFinal(UtilTests.inputRest()), UtilTests.outputRest());
    }
}