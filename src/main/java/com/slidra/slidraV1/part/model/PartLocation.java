package com.slidra.slidraV1.part.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PartLocation {
    private String warehouse;
    private String position;
}