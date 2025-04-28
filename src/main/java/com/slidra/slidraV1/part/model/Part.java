package com.slidra.slidraV1.part.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean isHaveDefect;

    private String defectDescription;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location partLocation;

    private Double price;
}

