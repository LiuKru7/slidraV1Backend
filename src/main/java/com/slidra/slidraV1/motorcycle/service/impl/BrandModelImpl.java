package com.slidra.slidraV1.motorcycle.service.impl;


import com.slidra.slidraV1.exception.exceptions.ResourceAlreadyExistsException;
import com.slidra.slidraV1.exception.exceptions.ResourceNotFoundException;
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
        log.info("Fetching all brands from the database.");
        List<Brand> brands = brandRepository.findAll();
        log.debug("Retrieved {} brands.", brands.size());
        return brands.stream()
                .map(brandMapper::toBrandResponse)
                .toList();
    }

    @Override
    public BrandResponse addNewBrand(BrandRequest brandRequest) {
        log.info("Attempting to add a new brand: {}", brandRequest.name());
        brandRepository.findByName(brandRequest.name())
                .ifPresent(brand -> {
                    log.warn("Brand with name '{}' already exists.", brandRequest.name());
                    throw new ResourceAlreadyExistsException("Brand already exists");
                });

        Brand brand = brandMapper.toBrand(brandRequest);
        Brand savedBrand = brandRepository.save(brand);
        log.info("Successfully added new brand with ID: {}", savedBrand.getId());
        return brandMapper.toBrandResponse(savedBrand);
    }

    @Override
    public BrandResponse updateBrandNameById(Long id, BrandRequest brandRequest) {
        log.info("Updating brand with ID: {} to new name: {}", id, brandRequest.name());
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Brand not found with ID: {}", id);
                    return new ResourceNotFoundException("Brand not found with id: " + id);
                });
        brand.setName(brandRequest.name());
        Brand updatedBrand = brandRepository.save(brand);
        log.info("Successfully updated brand with ID: {}", updatedBrand.getId());
        return brandMapper.toBrandResponse(updatedBrand);
    }
}

