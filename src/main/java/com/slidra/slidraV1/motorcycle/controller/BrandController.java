package com.slidra.slidraV1.motorcycle.controller;

import com.slidra.slidraV1.motorcycle.mapper.BrandMapper;
import com.slidra.slidraV1.motorcycle.service.BrandService;
import com.slidra.slidraV1.motorcycle.service.ModelService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/motorcycle/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;


    @GetMapping
    public ResponseEntity<?> getAllModels () {
        return ResponseEntity.ok("s");
    }


}
