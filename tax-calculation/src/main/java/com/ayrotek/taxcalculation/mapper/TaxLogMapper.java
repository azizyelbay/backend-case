package com.ayrotek.taxcalculation.mapper;

import com.ayrotek.taxcalculation.dto.ProductTaxDto;
import com.ayrotek.taxcalculation.dto.TaxLogDto;
import com.ayrotek.taxcalculation.model.TaxLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxLogMapper {

    public abstract TaxLog toEntity(ProductTaxDto dto);

    public abstract TaxLogDto toTaxLogDto(TaxLog taxLog);


}