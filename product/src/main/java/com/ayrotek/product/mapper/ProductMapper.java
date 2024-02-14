package com.ayrotek.product.mapper;

import com.ayrotek.product.dto.ProductDto;
import com.ayrotek.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "user.id", target = "userId")
    public abstract ProductDto toDto(Product product);

    @Mapping(source = "userId", target = "user.id")
    public abstract Product toEntity(ProductDto dto);

    public abstract List<ProductDto> toDtoList(List<Product> productList);

    public abstract Set<ProductDto> toDtoSet(Set<Product> productList);

}
