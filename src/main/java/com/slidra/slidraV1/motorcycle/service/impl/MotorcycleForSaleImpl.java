package com.slidra.slidraV1.motorcycle.service.impl;

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

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleForSaleImpl implements MotorcycleForSaleService {

    private final MotorcycleForSaleRepository motorcycleForSaleRepository;
    private final MotorcycleForSaleMapper motorcycleForSaleMapper;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Override
    public List<MotorcycleForSaleResponse> getALlMotorcycleForSale() {
        return motorcycleForSaleRepository.findAll().stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }
    @Override
    public MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest) {
        var model = modelRepository.findById(motorcycleForSaleRequest.modelId())
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + motorcycleForSaleRequest.modelId()));

        MotorcycleForSale motorcycleForSale = motorcycleForSaleMapper.toMotorcycleForSale(motorcycleForSaleRequest);
        motorcycleForSale.setModel(model);
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
        List<MotorcycleForSale> motorcycleByBrand = motorcycleForSaleRepository.findByModel_Name(model);

    }


}