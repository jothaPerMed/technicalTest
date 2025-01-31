package com.jgperea.technicalTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    /**
     * The Product id.
     */
    private Long productId;
    /**
     * The Name.
     */
    private String name;

}
