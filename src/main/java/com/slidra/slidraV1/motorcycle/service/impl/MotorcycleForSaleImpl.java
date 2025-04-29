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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Slf4j
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
        log.info("Fetching all motorcycles for sale");
        return motorcycleForSaleRepository.findAll().stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }

    @Override
    public MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest, MultipartFile file) {
        log.info("Adding new motorcycle for sale with modelId: {}", motorcycleForSaleRequest.modelId());

        var model = modelRepository.findById(motorcycleForSaleRequest.modelId())
                .orElseThrow(() -> {
                    log.error("Model not found with id: {}", motorcycleForSaleRequest.modelId());
                    return new RuntimeException("Model not found with id: " + motorcycleForSaleRequest.modelId());
                });

        String fileName = imageService.saveFile(file);

        MotorcycleForSale motorcycleForSale = motorcycleForSaleMapper.toMotorcycleForSale(motorcycleForSaleRequest);
        motorcycleForSale.setModel(model);
        motorcycleForSale.setPhotoUrls(List.of(fileName));
        MotorcycleForSale savedMotorcycle = motorcycleForSaleRepository.save(motorcycleForSale);

        log.info("Motorcycle for sale added with id: {}", savedMotorcycle.getId());

        return motorcycleForSaleMapper.toMotorcycleForSaleResponse(savedMotorcycle);
    }

    @Override
    public List<MotorcycleForSaleResponse> getMotorcyclesForSaleByBrand(String brand) {
        log.info("Fetching motorcycles for sale by brand: {}", brand);
        List<MotorcycleForSale> motorcycleByBrand = motorcycleForSaleRepository.findByModel_Brand_Name(brand);
        return motorcycleByBrand.stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }

    @Override
    public List<MotorcycleForSaleResponse> getMotorcyclesForSaleByModel(String model) {
        log.info("Fetching motorcycles for sale by model: {}", model);
        List<MotorcycleForSale> motorcycleByModel = motorcycleForSaleRepository.findByModel_Name(model);
        return motorcycleByModel.stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }

}