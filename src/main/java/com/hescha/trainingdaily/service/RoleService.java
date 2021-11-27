package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.Role;
import com.hescha.trainingdaily.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService extends CrudImpl<Role> {

	public RoleRepository repository;

	@Autowired
	public RoleService(RoleRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Role findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}

}
