package com.jgperea.technicalTest.infraestructure.outputadapter.persistence.repository;

import com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The interface Prices repository.
 */
@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Long> {


    /**
     * Find pvp final by product and brand id and date selected optional.
     *
     * @param idProduct the id product
     * @param brandId   the brand id
     * @param fecha     the fecha
     * @return the optional
     */

    @Nullable
    @Query(value = "SELECT *" +
            " FROM PRICES WHERE" +
            " PRODUCT_ID = ?1 AND" +
            " BRAND_ID = ?2 AND " +
            "?3>=" +
            "START_DATE AND " +
            "?3 <= END_DATE",
            nativeQuery = true)
    Optional<List<PricesEntity>> findPvpFinalByProductAndBrandIdAndDateSelected(Long idProduct, Long brandId,
                                                                                LocalDateTime fecha);

}
