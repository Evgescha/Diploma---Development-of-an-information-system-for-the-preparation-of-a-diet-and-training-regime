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

    public int getAllExercisesKkal() {
        int kkal = exercises.entrySet()
                .stream()
                .mapToInt(exercise -> exercise.getKey().getKkalInMinute() * exercise.getValue().intValue())
                .sum();
        return kkal;
    }

    @Override
    public int compareTo(@NotNull DailyRoutine o) {
        return date.compareTo(o.getDate());
    }
}
