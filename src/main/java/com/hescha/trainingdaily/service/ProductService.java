package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.Product;
import com.hescha.trainingdaily.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends CrudImpl<Product> {

	public ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
		this.repository = repository;
	}
}
