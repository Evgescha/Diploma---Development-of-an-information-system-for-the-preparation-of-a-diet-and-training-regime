package com.hescha.trainingdaily.model;


import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;

@Entity
@Data
public class EatingTime extends AbstractEntity implements Comparable<EatingTime>{
    private String name;
    private int numberInDay;

    @Override
    public int compareTo(@NotNull EatingTime o) {
        return numberInDay = o.getNumberInDay();
    }

    @Override
    public String toString() {
        return name;
    }
}
