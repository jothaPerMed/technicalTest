package com.jgperea.technicalTest.infraestructure.outputadapter.integration;


import com.jgperea.technicalTest.application.output.PriceOutputPort;
import com.jgperea.technicalTest.domain.exception.NotFoundException;
import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.Prices;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity.PricesEntity;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.mapper.PricePersistenceMapper;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.repository.PricesRepository;
import com.jgperea.technicalTest.util.Constant;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * The type Price output integration adapter.
 */
@AllArgsConstructor
@Component
public class PriceOutputIntegrationAdapter implements PriceOutputPort {
    /**
     * The Prices repository.
     */
    private final PricesRepository pricesRepository;
    /**
     * The Price persistence mapper.
     */
    private final PricePersistenceMapper pricePersistenceMapper;

    @SneakyThrows
    @Override
    public Prices pvpFinal(InputRest inputRest) {
        try {
            var priceEntity =
                    pricesRepository.findPvpFinalByProductAndBrandIdAndDateSelected(inputRest.getIdProducto(),
                                    inputRest.getIdCadena(),
                                    inputRest.getFechaEntrada());
            if (priceEntity.isPresent()) {
                return pricePersistenceMapper.toPrices(priceEntity.get().stream()
                        .max(Comparator.comparing(PricesEntity::getPriorityPrice)).get());
            }
            throw new NotFoundException(Constant.MESSAGE_ERROR_NOT_FOUND);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(Constant.MESSAGE_ERROR_NOT_FOUND);
        }
    }

}
