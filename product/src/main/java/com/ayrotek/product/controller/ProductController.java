package com.ayrotek.product.controller;

import com.ayrotek.product.dto.ProductDto;
import com.ayrotek.product.dto.ProductTaxResponseDto;
import com.ayrotek.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto request) {
        return ResponseEntity.ok(productService.saveProduct(request));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId,
                                                    @RequestBody ProductDto request) {

        return ResponseEntity.ok(productService.updateProduct(productId, request));
    }

    @DeleteMapping("/{productId}/{userId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId, @PathVariable Long userId) {
        productService.deleteProduct(productId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tax/{productId}/{userId}")
    public ResponseEntity<ProductTaxResponseDto> calculateProductTax(@PathVariable Long productId, @PathVariable Long userId) {
        return ResponseEntity.ok(productService.calculateTaxProduct(productId, userId));
    }
}
