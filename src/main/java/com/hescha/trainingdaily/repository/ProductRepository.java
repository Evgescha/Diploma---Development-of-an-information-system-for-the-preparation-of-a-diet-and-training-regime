package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIdIn(Long[] ids);
}
