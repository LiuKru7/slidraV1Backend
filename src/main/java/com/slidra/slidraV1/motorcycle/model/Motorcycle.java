package com.slidra.slidraV1.motorcycle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    private Integer year;
    private Integer mileage;
    private Double buyPrice;

    @ElementCollection
    @CollectionTable(name = "motorcycle_photos", joinColumns = @JoinColumn(name = "motorcycle_id"))
    @Column(name = "photo_url")
    private List<String> photoUrls;

    private String description;
}