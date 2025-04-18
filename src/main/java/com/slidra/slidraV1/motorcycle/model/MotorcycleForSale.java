package com.slidra.slidraV1.motorcycle.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MotorcycleForSale extends Motorcycle {
    private Double soldPrice;
    private Double sellPrice;
}
