package com.slidra.slidraV1.motorcycle.repository;

import com.slidra.slidraV1.motorcycle.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
