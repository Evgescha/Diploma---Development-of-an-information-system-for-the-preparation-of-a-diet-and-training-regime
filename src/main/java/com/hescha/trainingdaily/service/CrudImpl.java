package com.hescha.trainingdaily.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class CrudImpl<E> implements CrudService<E> {

    public JpaRepository<E, Long> repository;

    @Override
    public E create(E e) {
        return repository.saveAndFlush(e);
    }

    @Override
    public E read(long id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }

    @Override
    public E update(E E) {
        return repository.saveAndFlush(E);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public CrudImpl(JpaRepository<E, Long> repository) {
        this.repository = repository;
    }

    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
