package com.ayrotek.taxcalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TaxLogDto {
    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private Long userId;
    private BigDecimal taxPriceOfProduct;
}
