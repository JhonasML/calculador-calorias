package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository {
//    @Value("${food.file.path}")
    private String filePath = "src/main/resources/food.json";
    private File file = new File(filePath);
/*
    @Value("${food.file.path}")
    private String filePath;
    private File file;

    private final ObjectMapper mapper;

    @Autowired
    public FoodRepository(ObjectMapper mapper) {
        this.mapper = mapper;
        this.file = new File(filePath);
    }
 */
    private final ObjectMapper mapper;

    @Autowired
    public FoodRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Food> findFoods() {
        List<Food> foods = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(file);
            TypeReference<List<Food>> typeReference = new TypeReference<>() {};

            foods = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foods;
    }

    public Food findFoodByName(String name) {
        Optional<Food> foodFound = findFoods().stream().filter(f -> f.getName().equals(name)).findFirst();
        return foodFound.orElse(null);
    }

}
