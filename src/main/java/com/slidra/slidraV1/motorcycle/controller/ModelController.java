package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.ModelResponse;
import com.slidra.slidraV1.motorcycle.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycle/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping("/{brandId}")
    public ResponseEntity<List<ModelResponse>> getAllModelsByBrand(@PathVariable Long brandId) {

        return ResponseEntity.ok(modelService.getAllModelsByBrand(brandId));


    }




}
