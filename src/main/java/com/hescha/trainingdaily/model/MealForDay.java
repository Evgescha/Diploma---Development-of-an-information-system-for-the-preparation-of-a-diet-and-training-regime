package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class MealForDay extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "eatingTime_id")
    private EatingTime time;

    @ManyToOne
    @JoinColumn(name = "dailyRoutine_id")
    private DailyRoutine dailyRoutine;

    // food - gram
    @ElementCollection()
    @MapKeyColumn(name = "Product")
    private Map<Product, Integer> products = new HashMap<>();

    @ElementCollection()
    @MapKeyColumn(name = "Meal")
    private Map<Meal, Integer> meals = new HashMap<>();

    public int getAllKkalInTime() {
        int kkalFromProducts = products.entrySet()
                .stream()
                .mapToInt(food -> food.getKey().getKkalIn1gr() * food.getValue().intValue())
                .sum();

        int kkalFromMeals = meals.entrySet()
                .stream()
                .mapToInt(food -> food.getKey().getKkalIn1gr() * food.getValue().intValue())
                .sum();

        return kkalFromProducts + kkalFromMeals;
    }
}
