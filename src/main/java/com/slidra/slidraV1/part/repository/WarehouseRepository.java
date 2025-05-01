package com.slidra.slidraV1.part.repository;

import com.slidra.slidraV1.part.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
