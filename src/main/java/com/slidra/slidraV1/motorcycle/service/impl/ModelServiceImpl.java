package com.slidra.slidraV1.motorcycle.service.impl;


import com.slidra.slidraV1.exception.exceptions.ResourceNotFoundException;
import com.slidra.slidraV1.motorcycle.dto.ModelRequest;
import com.slidra.slidraV1.motorcycle.dto.ModelResponse;
import com.slidra.slidraV1.motorcycle.mapper.ModelMapper;
import com.slidra.slidraV1.motorcycle.model.Brand;
import com.slidra.slidraV1.motorcycle.repository.BrandRepository;
import com.slidra.slidraV1.motorcycle.repository.ModelRepository;
import com.slidra.slidraV1.motorcycle.service.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    @Override
    public List<ModelResponse> getAllModelsByBrand(Long brandId) {
        log.info("Fetching all models for brand with ID: {}", brandId);
        Brand brandById = brandRepository.findById(brandId)
                .orElseThrow(() -> {
                    log.error("Brand not found with ID: {}", brandId);
                    return new ResourceNotFoundException("Brand not found by id: " + brandId);
                });
        List<ModelResponse> models = brandById.getModels().stream()
                .map(modelMapper::toModelResponse)
                .toList();
        log.info("Retrieved {} models for brand ID: {}", models.size(), brandId);
        return models;
    }

    @Override
    public ModelResponse addNewModel(ModelRequest modelRequest) {
        log.info("Adding new model: {}", modelRequest);
        var savedModel = modelRepository.save(modelMapper.toModel(modelRequest));
        log.info("Successfully added new model with ID: {}", savedModel.getId());
        return modelMapper.toModelResponse(savedModel);
    }

    @Override
    public ModelResponse updateModelById(Long id, ModelRequest modelRequest) {
        log.info("Updating model with ID: {}", id);
        modelRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Model not found with ID: {}", id);
                    return new ResourceNotFoundException("Model not found by id: " + id);
                });
        var model = modelMapper.toModel(modelRequest);
        model.setId(id);
        var updatedModel = modelRepository.save(model);
        log.info("Successfully updated model with ID: {}", updatedModel.getId());
        return modelMapper.toModelResponse(updatedModel);
    }
}

