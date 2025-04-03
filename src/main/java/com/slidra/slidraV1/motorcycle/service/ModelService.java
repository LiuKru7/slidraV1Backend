package com.slidra.slidraV1.motorcycle.service;

import com.slidra.slidraV1.motorcycle.dto.ModelResponse;

import java.util.List;

public interface ModelService {
    List<ModelResponse> getAllModelsByBrand(Long brandId);
}
