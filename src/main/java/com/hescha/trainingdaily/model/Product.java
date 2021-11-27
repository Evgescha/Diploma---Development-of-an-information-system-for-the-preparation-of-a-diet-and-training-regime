package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Product extends AbstractFood {

    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    protected User addedBy;
}
