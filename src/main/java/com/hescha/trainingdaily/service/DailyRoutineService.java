package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.DailyRoutine;
import com.hescha.trainingdaily.repository.DailyRoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DailyRoutineService extends CrudImpl<DailyRoutine> {

	public DailyRoutineRepository repository;

	@Autowired
	public DailyRoutineService(DailyRoutineRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
