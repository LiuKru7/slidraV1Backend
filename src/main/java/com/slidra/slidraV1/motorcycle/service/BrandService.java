package com.slidra.slidraV1.motorcycle.service;

import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();

    BrandResponse addNewBrand(BrandRequest brandRequest);

    BrandResponse updateBrandNameById(Long id, BrandRequest brandRequest);
}
