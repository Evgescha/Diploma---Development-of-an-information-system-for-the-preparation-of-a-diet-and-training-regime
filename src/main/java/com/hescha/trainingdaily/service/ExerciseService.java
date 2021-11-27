package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.Exercise;
import com.hescha.trainingdaily.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExerciseService extends CrudImpl<Exercise> {

	public ExerciseRepository repository;

	@Autowired
	public ExerciseService(ExerciseRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
