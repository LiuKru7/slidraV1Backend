package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.service.MotorcycleForSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
