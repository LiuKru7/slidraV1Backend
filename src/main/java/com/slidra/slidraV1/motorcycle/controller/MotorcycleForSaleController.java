package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.service.MotorcycleForSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<MotorcycleForSaleResponse> addNewMotorcycleForSale (@RequestBody MotorcycleForSaleRequest motorcycleForSaleRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(motorcycleForSaleService.addNewMotorcycleForSale(motorcycleForSaleRequest));
    }

}
