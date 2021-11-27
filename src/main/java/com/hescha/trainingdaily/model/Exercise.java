package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Exercise extends AbstractEntity {
    private String name;
    private int kkalInHour;
    private int kkalInMinute;
    private boolean approved;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    private User addedBy;
}
