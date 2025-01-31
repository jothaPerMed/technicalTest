package com.jgperea.technicalTest.application.input;

import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.OutputRest;

/**
 * The interface Price use case.
 */
public interface PriceUseCase {
    /**
     * Pvp final output rest.
     *
     * @param inputRest the input rest
     * @return the output rest
     */
    OutputRest pvpFinal(InputRest inputRest);
}
