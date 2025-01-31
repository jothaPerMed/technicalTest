package com.jgperea.technicalTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Prices.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Prices  {

    /**
     * The Product.
     */
    private Product product;
    /**
     * The Brand.
     */
    private Brand brand;
    /**
     * The Star date.
     */
    private LocalDateTime starDate;
    /**
     * The En date.
     */
    private LocalDateTime enDate;
    /**
     * The Price list.
     */
    private Long priceList;
    /**
     * The Priority.
     */
    private Long priority;
    /**
     * The Price.
     */
    private BigDecimal price;
    /**
     * The Curr.
     */
    private String curr;
}
