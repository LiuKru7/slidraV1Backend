package com.slidra.slidraV1.motorcycle.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MotorcycleForSaleService  {
    List<MotorcycleForSaleResponse> getALlMotorcycleForSale();
}
