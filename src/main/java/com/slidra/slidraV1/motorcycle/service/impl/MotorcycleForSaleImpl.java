package com.slidra.slidraV1.motorcycle.service.impl;

import com.slidra.slidraV1.Image.service.ImageService;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.mapper.MotorcycleForSaleMapper;
import com.slidra.slidraV1.motorcycle.model.MotorcycleForSale;
import com.slidra.slidraV1.motorcycle.repository.BrandRepository;
import com.slidra.slidraV1.motorcycle.repository.ModelRepository;
import com.slidra.slidraV1.motorcycle.repository.MotorcycleForSaleRepository;
import com.slidra.slidraV1.motorcycle.service.MotorcycleForSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MotorcycleForSaleImpl implements MotorcycleForSaleService {

    private final MotorcycleForSaleRepository motorcycleForSaleRepository;
    private final MotorcycleForSaleMapper motorcycleForSaleMapper;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ImageService imageService;

    @Override
    public List<MotorcycleForSaleResponse> getALlMotorcycleForSale() {
        return motorcycleForSaleRepository.findAll().stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }
    @Override
    public MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest, MultipartFile file) {
        var model = modelRepository.findById(motorcycleForSaleRequest.modelId())
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + motorcycleForSaleRequest.modelId()));

        String fileName =  imageService.saveFile(file);


        MotorcycleForSale motorcycleForSale = motorcycleForSaleMapper.toMotorcycleForSale(motorcycleForSaleRequest);
        motorcycleForSale.setModel(model);
        motorcycleForSale.setPhotoUrls(List.of(fileName));
        return motorcycleForSaleMapper.toMotorcycleForSaleResponse(motorcycleForSaleRepository.save(motorcycleForSale));
    }

    @Override
    public List<MotorcycleForSaleResponse> getMotorcyclesForSaleByBrand(String brand) {
        List<MotorcycleForSale> motorcycleByBrand = motorcycleForSaleRepository.findByModel_Brand_Name(brand);
        return motorcycleByBrand.stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }

    @Override
    public List<MotorcycleForSaleResponse> getMotorcyclesForSaleByModel(String model) {
        List<MotorcycleForSale> motorcycleByModel = motorcycleForSaleRepository.findByModel_Name(model);
        return motorcycleByModel.stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();

    }




}