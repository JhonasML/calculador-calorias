package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.entity.Food;
import com.meli.calculadoracalorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoods() {
        return foodRepository.findFoods();
    }

    public Food getFoodByName(String name) {
        return foodRepository.findFoodByName(name);
    }
}
