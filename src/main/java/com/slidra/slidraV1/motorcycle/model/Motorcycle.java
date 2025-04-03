package com.slidra.slidraV1.motorcycle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "motorcycles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    private Integer year;
    private Integer mileage;
    private Double price;

    @ElementCollection
    @CollectionTable(name = "motorcycle_photos", joinColumns = @JoinColumn(name = "motorcycle_id"))
    @Column(name = "photo_url")
    private List<String> photosUrls;

    private String description;
}