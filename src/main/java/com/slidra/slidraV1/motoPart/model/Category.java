package com.slidra.slidraV1.motoPart.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long ebayCategoryId;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> subCategories = new ArrayList<>();

}