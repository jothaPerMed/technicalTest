package com.jgperea.technicalTest.util;

import java.math.BigDecimal;

/**
 * The enum Enum product.
 */
public enum EnumProduct {
    /**
     * The Test.
     */
    TEST(new BigDecimal(1));
    /**
     * The Product id.
     */
    public final BigDecimal productId;

    /**
     * Instantiates a new Enum product.
     *
     * @param productId the product id
     */
    EnumProduct(BigDecimal productId){
        this.productId=productId;
    }
}
