package com.hescha.trainingdaily.service;

import java.util.List;

public interface CrudService<E> {

	E create(E E);

	E read(long id);

	E update(E e);

	void delete(long id);

	List<E> findAll();
	
}