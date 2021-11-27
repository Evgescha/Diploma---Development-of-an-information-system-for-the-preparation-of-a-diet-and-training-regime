package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractFood extends AbstractEntity {
    protected String name;
    protected String image;
    protected int kkalIn100gr;
    protected int kkalIn1gr;
    protected boolean approved;
    protected boolean deleted;
}
