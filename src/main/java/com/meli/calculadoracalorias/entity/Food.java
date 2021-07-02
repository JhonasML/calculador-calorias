package com.meli.calculadoracalorias.entity;

import com.meli.calculadoracalorias.dtos.FoodDTO;
import lombok.Data;

@Data
public class Food {
    private String name;
    private Integer calories;

    public FoodDTO toDTO() {
        return new FoodDTO(this.name);
    }
}
