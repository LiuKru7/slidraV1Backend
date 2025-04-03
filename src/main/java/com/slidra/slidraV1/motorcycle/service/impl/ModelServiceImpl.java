package com.slidra.slidraV1.motorcycle.service.impl;


import com.slidra.slidraV1.motorcycle.dto.ModelResponse;
import com.slidra.slidraV1.motorcycle.mapper.ModelMapper;
import com.slidra.slidraV1.motorcycle.model.Brand;
import com.slidra.slidraV1.motorcycle.repository.BrandRepository;
import com.slidra.slidraV1.motorcycle.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ModelResponse> getAllModelsByBrand(Long brandId) {
        Brand brandById = brandRepository.findById(brandId)
                //todo need change exception
                .orElseThrow(()-> new RuntimeException("Brand not found"));
        return brandById.getModels().stream()
                .map(modelMapper::toModelResponse)
                .toList();
    }
}
