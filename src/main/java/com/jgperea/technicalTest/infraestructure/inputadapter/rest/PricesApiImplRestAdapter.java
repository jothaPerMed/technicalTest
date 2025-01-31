package com.jgperea.technicalTest.infraestructure.inputadapter.rest;

import com.jgperea.technicalTest.application.input.PriceUseCase;
import com.jgperea.technicalTest.infraestructure.inputadapter.mapper.PriceRestMapper;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.InputDTO;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.OutputDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Prices api impl rest adapter.
 */
@AllArgsConstructor
@RestController
public class PricesApiImplRestAdapter implements PricesApi {
    /**
     * The Price rest mapper.
     */
    private final PriceRestMapper priceRestMapper;
    /**
     * The Price use case.
     */
    private final PriceUseCase priceUseCase;

    @Override
    public ResponseEntity<OutputDTO> finalPrice(InputDTO inputDTO) {
        return ResponseEntity.ok(priceRestMapper.toOutputDTO(
                priceUseCase.pvpFinal(priceRestMapper.toInputRest(inputDTO))
        ));
    }
}
