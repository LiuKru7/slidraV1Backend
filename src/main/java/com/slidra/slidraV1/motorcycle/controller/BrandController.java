package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;
import com.slidra.slidraV1.motorcycle.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/motorcycle/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllModels() {
        log.info("GET request received: Fetching all brands");
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BrandResponse> addNewBrand(@RequestBody BrandRequest brandRequest) {
        log.info("POST request received: Adding new brand with name: {}", brandRequest.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.addNewBrand(brandRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BrandResponse> updateBrandNameById(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        log.info("PUT request received: Updating brand with id: {} to new name: {}", id, brandRequest.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.updateBrandNameById(id, brandRequest));
    }
}
