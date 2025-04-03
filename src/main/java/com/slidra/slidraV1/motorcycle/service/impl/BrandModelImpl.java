package com.slidra.slidraV1.motorcycle.service.impl;


import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;
import com.slidra.slidraV1.motorcycle.mapper.BrandMapper;
import com.slidra.slidraV1.motorcycle.model.Brand;
import com.slidra.slidraV1.motorcycle.repository.BrandRepository;
import com.slidra.slidraV1.motorcycle.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandModelImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public List<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandMapper::toBrandResponse)
                .toList();
    }

    @Override
    public BrandResponse addNewBrand(BrandRequest brandRequest) {
        brandRepository.findByName(brandRequest.name())
                .ifPresent(brand -> {
                    throw new RuntimeException("Brand already exists"); // todo pakeisti išimtį
                });

        Brand brand = brandMapper.toBrand(brandRequest);
        Brand savedBrand = brandRepository.save(brand);

        return brandMapper.toBrandResponse(savedBrand);
    }

    @Override
    public BrandResponse updateBrandNameById(Long id, BrandRequest brandRequest) {
        var brand =brandRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Brand not exists"));
        brand.setName(brandRequest.name());
        return brandMapper.toBrandResponse(brandRepository.save(brand));
    }

}
