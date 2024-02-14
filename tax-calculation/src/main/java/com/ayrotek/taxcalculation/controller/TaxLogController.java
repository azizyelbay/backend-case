package com.ayrotek.taxcalculation.controller;

import com.ayrotek.taxcalculation.dto.ProductTaxDto;
import com.ayrotek.taxcalculation.dto.TaxLogDto;
import com.ayrotek.taxcalculation.model.TaxLog;
import com.ayrotek.taxcalculation.service.TaxLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tax")
@Slf4j
@RequiredArgsConstructor
public class TaxLogController {

    private final TaxLogService taxLogService;

    @PostMapping
    public ResponseEntity<TaxLog> calculateTax(@RequestBody ProductTaxDto request) {
        return ResponseEntity.ok(taxLogService.calculateTax(request));
    }

}
