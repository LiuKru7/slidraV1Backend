package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;
import com.slidra.slidraV1.motorcycle.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycle/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllModels () {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BrandResponse>addNewBrand(@RequestBody BrandRequest brandRequest){
        return ResponseEntity.ok(brandService.addNewBrand(brandRequest));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BrandResponse> updateBrandNameById(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        return ResponseEntity.ok(brandService.updateBrandNameById(id, brandRequest));
    }


}
