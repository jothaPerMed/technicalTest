package com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "PricesEntity")
@Table(name = "PRICES")
@NoArgsConstructor
@Builder
@IdClass(PricesEntity.class)
public class PricesEntity implements Serializable {
    @Id
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime starDate;
    @Id
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime enDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST", nullable = false)
    private Long priceList;
    @Id
    @Column(name = "PRIORITY_PRICE", nullable = false)
    private Long priorityPrice;
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    @Column(name = "CURR", nullable = false)
    private String curr;
    @ManyToOne(optional = false)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID")
    private BrandEntity brandEntity;
    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private ProductEntity productEntity;


}
