package com.jgperea.technicalTest.infraestructure.outputadapter.persistence.mapper;

import com.jgperea.technicalTest.domain.model.Prices;
import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity.PricesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price rest mapper.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PricePersistenceMapper {

    /**
     * To input rest input rest.
     *
     * @param pricesEntity the prices entity
     * @return the input rest
     */
    @Mapping(target = ".", source = ".")
    @Mapping(target = "product.productId", source = "productEntity.productId")
    @Mapping(target = "product.name", source = "productEntity.name")
    @Mapping(target = "brand.brandId", source = "brandEntity.brandId")
    @Mapping(target = "brand.name", source = "brandEntity.name")
    @Mapping(target = "priority", source = "priorityPrice")
    Prices toPrices(PricesEntity pricesEntity);
}
