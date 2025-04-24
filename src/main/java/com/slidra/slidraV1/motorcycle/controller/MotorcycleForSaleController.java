package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.service.MotorcycleForSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycle/sale")
@RequiredArgsConstructor
public class MotorcycleForSaleController {

    private final MotorcycleForSaleService motorcycleForSaleService;

    @GetMapping
    public ResponseEntity<List<MotorcycleForSaleResponse>> getAllMotorcycleForSale () {
        return ResponseEntity.ok(motorcycleForSaleService.getALlMotorcycleForSale());
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<MotorcycleForSaleResponse>> getMotorcycleForSaleByBrand(@PathVariable String brand){
        return ResponseEntity.ok(motorcycleForSaleService.getMotorcyclesForSaleByBrand(brand));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<MotorcycleForSaleResponse>> getMotorcycleForSaleByModel(@PathVariable String model){
        return ResponseEntity.ok(motorcycleForSaleService.getMotorcyclesForSaleByModel(model));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MotorcycleForSaleResponse> addNewMotorcycleForSale(
            @RequestPart("motorcycle") MotorcycleForSaleRequest request,
            @RequestPart("file") MultipartFile file) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(motorcycleForSaleService.addNewMotorcycleForSale(request, file));
    }


}
