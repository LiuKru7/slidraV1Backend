package com.slidra.slidraV1.motorcycle.model;

import com.slidra.slidraV1.motorcycle.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private Integer yearFrom;
    private Integer yearTo;
    private String generation;
    private String category;
    private Integer engineDisplacement;
    private Integer horsepower;
    private Double weight;
    @Enumerated (EnumType.STRING)
    private FuelType fuelType;
}