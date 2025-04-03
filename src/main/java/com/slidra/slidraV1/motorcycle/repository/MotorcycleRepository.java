package com.slidra.slidraV1.motorcycle.repository;

import com.slidra.slidraV1.motorcycle.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
}
