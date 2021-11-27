package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.MealForDay;
import com.hescha.trainingdaily.repository.MealForDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MealForDayService extends CrudImpl<MealForDay> {

	public MealForDayRepository repository;

	@Autowired
	public MealForDayService(MealForDayRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
