package com.slidra.slidraV1.motorcycle.model;

import com.slidra.slidraV1.motoPart.model.Part;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MotorcycleForParts extends Motorcycle {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "motorcycle_id")
    private List<Part> partList;
}
