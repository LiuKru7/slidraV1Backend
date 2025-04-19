package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.ModelRequest;
import com.slidra.slidraV1.motorcycle.dto.ModelResponse;
import com.slidra.slidraV1.motorcycle.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycle/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping("/{brandId}")
    public ResponseEntity<List<ModelResponse>> getAllModelsByBrand(
            @PathVariable Long brandId) {
        return ResponseEntity.ok(modelService.getAllModelsByBrand(brandId));
    }

    @PostMapping
    public ResponseEntity<ModelResponse> addNewModel(
            @RequestBody ModelRequest modelRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelService.addNewModel(modelRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ModelResponse> updateModelById(
            @PathVariable Long id, @RequestBody ModelRequest modelRequest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelService.updateModelById(id, modelRequest));
    }
}
