package com.hescha.trainingdaily.model;


import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EatingTime that = (EatingTime) o;
        return numberInDay == that.numberInDay && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, numberInDay);
    }
}
