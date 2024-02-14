package com.ayrotek.taxcalculation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Document
@Getter
@Setter
@SuperBuilder
public class TaxLog {

    @Id
    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private Long userId;
    // calculated
    private BigDecimal taxPriceOfProduct;

}
