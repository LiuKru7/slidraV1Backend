package com.slidra.slidraV1.motorcycle.service;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;

import java.util.List;

public interface MotorcycleForSaleService  {
    List<MotorcycleForSaleResponse> getALlMotorcycleForSale();

    MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest);

    List<MotorcycleForSaleResponse> getMotorcyclesForSaleByBrand(String brand);

    List<MotorcycleForSaleResponse> getMotorcyclesForSaleByModel(String model);
}
