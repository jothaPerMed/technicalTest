package com.jgperea.technicalTest.infraestructure.outputadapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BrandEntity")
@Table(name = "BRAND")
@Builder
public class BrandEntity implements Serializable {
    @Id
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;
    @Column(name = "BRAND_NAME", nullable = false)
    private String name;
}
