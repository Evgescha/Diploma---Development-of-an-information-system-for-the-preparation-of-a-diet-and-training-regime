package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Product extends AbstractEntity {
    protected String name;
    protected String image;
    protected String description;
    protected int kkalIn100gr;
    protected float kkalIn1gr;
    protected boolean approved;

    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    protected User addedBy;
}
