package com.hescha.trainingdaily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return kkalIn100gr == product.kkalIn100gr &&
                Float.compare(product.kkalIn1gr, kkalIn1gr) == 0
                && approved == product.approved
                && Objects.equals(name, product.name)
                && Objects.equals(image, product.image)
                && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, image, description, kkalIn100gr, kkalIn1gr, approved);
    }
}
