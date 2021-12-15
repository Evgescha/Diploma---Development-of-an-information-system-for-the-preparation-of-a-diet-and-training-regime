package com.hescha.trainingdaily.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class MealForDay extends AbstractEntity implements Comparable<MealForDay> {
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

    public float getAllKkalInTime() {
        double kkalFromProducts = products.entrySet()
                .stream()
                .mapToDouble(food -> food.getKey().getKkalIn1gr() * food.getValue().intValue())
                .sum();

        return (float) (kkalFromProducts);
    }

    @Override
    public int compareTo(@NotNull MealForDay o) {
        return time.compareTo(o.getTime());
    }
}
