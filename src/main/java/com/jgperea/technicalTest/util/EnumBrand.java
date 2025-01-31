package com.jgperea.technicalTest.util;

import java.math.BigDecimal;

public enum EnumBrand {
    ZARA(new BigDecimal(1));
    public final BigDecimal branId;
    EnumBrand(BigDecimal branId){
        this.branId=branId;
    }
}
