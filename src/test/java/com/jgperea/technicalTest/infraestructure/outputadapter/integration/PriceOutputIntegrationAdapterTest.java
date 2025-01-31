package com.jgperea.technicalTest.infraestructure.outputadapter.integration;

import com.jgperea.technicalTest.domain.exception.NotFoundException;
import com.jgperea.technicalTest.domain.model.Brand;
import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.Prices;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity.BrandEntity;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity.PricesEntity;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.mapper.PricePersistenceMapper;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.repository.PricesRepository;
import com.jgperea.technicalTest.util.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

/**
 * The type Price output integration adapter test.
 */
@ExtendWith(MockitoExtension.class)
class PriceOutputIntegrationAdapterTest {
    @Mock
    private PricePersistenceMapper pricePersistenceMapper;
    @Mock
    private PricesRepository pricesRepository;
    @InjectMocks
    private PriceOutputIntegrationAdapter priceOutputIntegrationAdapter;

    /**
     * Pvp final.
     */
    @Test
    void pvpFinal() {
        var fecha = LocalDateTime.of(2020, 12, 14, 10, 00, 00);
        Mockito.when(pricePersistenceMapper.toPrices(any())).thenReturn(Prices.builder().enDate(fecha).starDate(fecha).brand(Brand.builder().brandId(1L).build()).build());
        Mockito.when(pricesRepository.findPvpFinalByProductAndBrandIdAndDateSelected(any(), any(), any())).thenReturn(Optional.of(Arrays.asList(PricesEntity.builder().starDate(fecha).brandEntity(BrandEntity.builder().brandId(1L).build()).build())));
        assertEquals(priceOutputIntegrationAdapter.pvpFinal(InputRest.builder().fechaEntrada(Timestamp.from(fecha.toInstant(ZoneOffset.UTC)).toLocalDateTime()).build()).getBrand().getBrandId(), 1L);
    }

    /**
     * Pvp final not found.
     */
    @Test
    void pvpFinalNotFound() {
        var fecha = LocalDateTime.of(2025, 12, 14, 10, 00, 00);
        var ex = assertThrows(NotFoundException.class, () ->
                priceOutputIntegrationAdapter.pvpFinal(InputRest.builder().fechaEntrada(Timestamp.from(fecha.toInstant(ZoneOffset.UTC)).toLocalDateTime()).build()).getBrand().getBrandId());
        assertEquals(NotFoundException.class, ex.getClass());
        assertEquals(ex.getMessage(), Constant.MESSAGE_ERROR_NOT_FOUND);
    }
}