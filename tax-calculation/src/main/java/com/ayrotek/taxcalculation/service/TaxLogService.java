package com.ayrotek.taxcalculation.service;

import com.ayrotek.taxcalculation.dto.ProductTaxDto;
import com.ayrotek.taxcalculation.dto.TaxLogDto;
import com.ayrotek.taxcalculation.mapper.TaxLogMapper;
import com.ayrotek.taxcalculation.model.TaxLog;
import com.ayrotek.taxcalculation.repository.TaxLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class TaxLogService {

    private final TaxLogRepository taxLogRepository;
    private final TaxLogMapper taxLogMapper;

    public TaxLog calculateTax(ProductTaxDto productTaxDto){
        BigDecimal taxRate = productTaxDto.getTax();
        BigDecimal price = productTaxDto.getPrice();
        BigDecimal result = price.multiply(taxRate).divide(new BigDecimal(100),2, RoundingMode.HALF_UP);


        TaxLog taxLog = TaxLog.builder()
                .name(productTaxDto.getName())
                .id(productTaxDto.getId())
                .tax(productTaxDto.getTax())
                .price(productTaxDto.getPrice())
                .userId(productTaxDto.getUserId())
                .taxPriceOfProduct(result)
                .build();

        return taxLogRepository.save(taxLog);
    }
}
