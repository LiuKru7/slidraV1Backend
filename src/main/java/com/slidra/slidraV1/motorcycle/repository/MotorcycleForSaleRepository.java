package com.slidra.slidraV1.motorcycle.repository;


import com.slidra.slidraV1.motorcycle.model.MotorcycleForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleForSaleRepository extends JpaRepository<MotorcycleForSale, Long> {

    List<MotorcycleForSale> findByModel_Brand_Name(String brandName);

    List<MotorcycleForSale> findByModel_Name(String model);
}
