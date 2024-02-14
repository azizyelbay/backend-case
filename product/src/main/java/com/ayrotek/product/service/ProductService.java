package com.ayrotek.product.service;

import com.ayrotek.product.dto.ProductDto;
import com.ayrotek.product.dto.ProductTaxResponseDto;
import com.ayrotek.product.exception.ProductNotFoundException;
import com.ayrotek.product.mapper.ProductMapper;
import com.ayrotek.product.model.Product;
import com.ayrotek.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserService userService;
    private final RestTemplate restTemplate;

    private static final String url = "http://localhost:8082/v1/tax" ;

    @Transactional
    public ProductDto saveProduct(ProductDto dto) {
        userService.findUserById(dto.getUserId());

        Product product = productMapper.toEntity(dto);

        return productMapper.toDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDto getProductById(Long productId) {
        return productMapper.toDto(findProductById(productId));
    }

    @Transactional
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        Product product = findProductByIdAndUserId(productId, productDto.getUserId());

        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setTax(productDto.getTax());

        return productMapper.toDto(productRepository.save(product));
    }

    public void deleteProduct(Long productId, Long userId) {
        findProductByIdAndUserId(productId, userId);
        productRepository.deleteById(productId);
    }

    protected Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not find by id: " + id));
    }

    protected Product findProductByIdAndUserId(Long productId, Long userId) {
        return productRepository.findByIdAndUserId(productId, userId)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not find by id: " + productId + " userId: " + userId));
    }

    public ProductTaxResponseDto calculateTaxProduct(Long productId, Long userId) {
        ProductDto request = productMapper.toDto(findProductByIdAndUserId(productId, userId));

        ProductTaxResponseDto result = restTemplate.postForObject(url, request, ProductTaxResponseDto.class);
        return result;
    }
}
