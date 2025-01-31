package com.jgperea.technicalTest.domain.mapper;

import com.jgperea.technicalTest.domain.model.OutputRest;
import com.jgperea.technicalTest.domain.model.Prices;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price rest mapper.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PriceDomainMapper {

    /**
     * To input rest input rest.
     *
     * @param prices the prices
     * @return the input rest
     */
    @Mapping(target = "idProducto", source = "product.productId")
    @Mapping(target = "idCadena", source = "brand.brandId")
    @Mapping(target = "tarifaAplicar", source = "priceList")
    @Mapping(target = "fechaEntrada", source = "starDate")
    @Mapping(target = "fechaSalida", source = "enDate")
    @Mapping(target = "precioFinalAplicar", source = "price")
    OutputRest toOutputRest(Prices prices);
}
