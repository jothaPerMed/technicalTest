package com.jgperea.technicalTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Brand.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Brand {
    /**
     * The Brand id.
     */
    private Long brandId;
    /**
     * The Name.
     */
    private String name;
}
