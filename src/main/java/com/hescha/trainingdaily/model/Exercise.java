package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Data
public class Exercise extends AbstractEntity {
    private String name;
    private String description;
    private int kkalInHour;
    private float kkalInMinute;
    private boolean approved;

    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    private User addedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Exercise exercise = (Exercise) o;
        return kkalInHour == exercise.kkalInHour
                && Float.compare(exercise.kkalInMinute, kkalInMinute) == 0
                && approved == exercise.approved
                && Objects.equals(name, exercise.name)
                && Objects.equals(description, exercise.description)
                && Objects.equals(addedBy.getUsername().hashCode(), exercise.addedBy.getUsername().hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, kkalInHour, kkalInMinute, approved, addedBy.getUsername().hashCode());
    }
}
