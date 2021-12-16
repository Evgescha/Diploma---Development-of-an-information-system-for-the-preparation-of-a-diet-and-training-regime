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
import java.util.Objects;

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

    public double getAllKkalInTime() {
        double kkalFromProducts = products.entrySet()
                .stream()
                .mapToDouble(food -> food.getKey().getKkalIn1gr() * food.getValue().intValue())
                .sum();

        return  new Float(kkalFromProducts).shortValue();
    }

    @Override
    public int compareTo(@NotNull MealForDay o) {
        return time.compareTo(o.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MealForDay that = (MealForDay) o;
        return Objects.equals(time, that.time) && Objects.equals(dailyRoutine.getId(), that.dailyRoutine.getId()) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time, dailyRoutine.getId(), products);
    }
}
