package com.hescha.trainingdaily.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.*;

@Entity
@Data
public class DailyRoutine extends AbstractEntity implements Comparable<DailyRoutine> {
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    private Date date;

    @ElementCollection(targetClass=Integer.class)
    @MapKeyColumn(name="Exercise")
    private Map<Exercise, Integer> exercises = new HashMap<>();

    @OneToMany(mappedBy = "dailyRoutine", fetch = FetchType.LAZY)
    private Set<MealForDay> mealForDays = new TreeSet<>();

    public float getAllExercisesKkal() {
        double kkal = exercises.entrySet()
                .stream()
                .mapToDouble(exercise -> exercise.getKey().getKkalInMinute() * exercise.getValue().intValue())
                .sum();
        return new Float(kkal).shortValue();
    }

    public float getAllProductsKkal() {
        double kkal = mealForDays
                .stream()
                .mapToDouble(meal->meal.getAllKkalInTime())
                .sum();
        return new Float(kkal).shortValue();
    }

    @Override
    public int compareTo(@NotNull DailyRoutine o) {
        return date.compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DailyRoutine that = (DailyRoutine) o;
        return Objects.equals(user.getUsername().hashCode(), that.user.getUsername().hashCode())
                && Objects.equals(date, that.date)
                && Objects.equals(exercises, that.exercises)
                && Objects.equals(mealForDays, that.mealForDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user.getUsername().hashCode(), date, exercises, mealForDays);
    }
}
