package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.service.MotorcycleForSaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/motorcycle/sale")
@RequiredArgsConstructor
public class MotorcycleForSaleController {

    private final MotorcycleForSaleService motorcycleForSaleService;

    @GetMapping
    public ResponseEntity<List<MotorcycleForSaleResponse>> getAllMotorcycleForSale() {
        log.info("GET request received: Fetching all motorcycles for sale");
        return ResponseEntity.ok(motorcycleForSaleService.getALlMotorcycleForSale());
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<MotorcycleForSaleResponse>> getMotorcycleForSaleByBrand(@PathVariable String brand) {
        log.info("GET request received: Fetching motorcycles for sale by brand: {}", brand);
        return ResponseEntity.ok(motorcycleForSaleService.getMotorcyclesForSaleByBrand(brand));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<MotorcycleForSaleResponse>> getMotorcycleForSaleByModel(@PathVariable String model) {
        log.info("GET request received: Fetching motorcycles for sale by model: {}", model);
        return ResponseEntity.ok(motorcycleForSaleService.getMotorcyclesForSaleByModel(model));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MotorcycleForSaleResponse> addNewMotorcycleForSale(
            @RequestPart("motorcycle") MotorcycleForSaleRequest request,
            @RequestPart("file") MultipartFile file) {

        log.info("POST request received: Adding new motorcycle for sale, modelId: {}", request.modelId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(motorcycleForSaleService.addNewMotorcycleForSale(request, file));
    }
}
