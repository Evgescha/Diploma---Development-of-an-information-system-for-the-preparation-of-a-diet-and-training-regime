package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Meal extends AbstractFood {

    @ManyToOne
    @JoinColumn(name = "addedBy_id")
    protected User addedBy;

    //product - gram from this product
    @ElementCollection(targetClass = Integer.class)
    @MapKeyColumn(name = "Product")
    private Map<Product, Integer> foods = new HashMap<>();
}
