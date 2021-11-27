package com.hescha.trainingdaily.model;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class EatingTime extends AbstractEntity {
    private String name;
    private int numberInDay;
}
