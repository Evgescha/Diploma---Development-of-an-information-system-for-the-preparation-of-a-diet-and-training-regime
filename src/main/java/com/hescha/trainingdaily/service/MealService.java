package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.Meal;
import com.hescha.trainingdaily.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MealService extends CrudImpl<Meal> {

	public MealRepository repository;

	@Autowired
	public MealService(MealRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
