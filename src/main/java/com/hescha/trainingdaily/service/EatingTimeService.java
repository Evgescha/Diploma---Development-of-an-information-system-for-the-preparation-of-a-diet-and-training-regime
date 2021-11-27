package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.EatingTime;
import com.hescha.trainingdaily.repository.EatingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EatingTimeService extends CrudImpl<EatingTime> {

	public EatingTimeRepository repository;

	@Autowired
	public EatingTimeService(EatingTimeRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
