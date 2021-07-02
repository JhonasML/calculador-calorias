package com.meli.calculadoracalorias.controllers;

import com.meli.calculadoracalorias.dtos.FoodDTO;
import com.meli.calculadoracalorias.entity.Food;
import com.meli.calculadoracalorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<FoodDTO> getFoods() {
        return foodService.getFoods().stream().map(Food::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public FoodDTO getFoodByName(@PathVariable String name) {
        return foodService.getFoodByName(name).toDTO();
    }
}
