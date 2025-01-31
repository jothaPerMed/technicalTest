package com.jgperea.technicalTest.application.output;

import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.Prices;

/**
 * The interface Price use case.
 */
public interface PriceOutputPort {
    /**
     * Pvp final output rest.
     *
     * @param inputRest the input rest
     * @return the output rest
     */
    Prices pvpFinal(InputRest inputRest);
}
