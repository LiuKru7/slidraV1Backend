package com.slidra.slidraV1.motorcycle.service;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MotorcycleForSaleService  {
    List<MotorcycleForSaleResponse> getALlMotorcycleForSale();

    MotorcycleForSaleResponse addNewMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest, MultipartFile file);

    List<MotorcycleForSaleResponse> getMotorcyclesForSaleByBrand(String brand);

    List<MotorcycleForSaleResponse> getMotorcyclesForSaleByModel(String model);
}
