package com.slidra.slidraV1.motorcycle.service.impl;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.mapper.MotorcycleForSaleMapper;
import com.slidra.slidraV1.motorcycle.model.MotorcycleForSale;
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

    @Override
    public List<MotorcycleForSaleResponse> getALlMotorcycleForSale() {
        return motorcycleForSaleRepository.findAll().stream()
                .map(motorcycleForSaleMapper::toMotorcycleForSaleResponse)
                .toList();
    }

    @Override
    public MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest) {
        MotorcycleForSale motorcycleForSale = motorcycleForSaleMapper.toMotorcycleForSale(motorcycleForSaleRequest);
        return motorcycleForSaleMapper.toMotorcycleForSaleResponse(motorcycleForSaleRepository.save(motorcycleForSale));
    }
}
