package com.jgperea.technicalTest.application.usecase;

import com.jgperea.technicalTest.application.input.PriceUseCase;
import com.jgperea.technicalTest.domain.mapper.PriceDomainMapper;
import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.OutputRest;
import com.jgperea.technicalTest.infraestructure.outputadapter.integration.PriceOutputIntegrationAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type Price use case.
 */
@AllArgsConstructor
@Component
public class PriceUseCaseImpl implements PriceUseCase {
    /**
     * The Price output integration adapter.
     */
    private final PriceOutputIntegrationAdapter priceOutputIntegrationAdapter;
    /**
     * The Price domain mapper.
     */
    private final PriceDomainMapper priceDomainMapper;

    @Override
    public OutputRest pvpFinal(InputRest inputRest) {
        return priceDomainMapper.toOutputRest(priceOutputIntegrationAdapter.pvpFinal(inputRest));
    }
}
