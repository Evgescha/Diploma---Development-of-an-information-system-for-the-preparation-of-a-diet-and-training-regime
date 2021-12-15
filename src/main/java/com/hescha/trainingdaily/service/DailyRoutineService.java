package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.DailyRoutine;
import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.repository.DailyRoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Service
public class DailyRoutineService extends CrudImpl<DailyRoutine> {

    public DailyRoutineRepository repository;

    @Autowired
    public DailyRoutineService(DailyRoutineRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public boolean isExistsByDateAndUser(Date date, User user) {
        return repository.existsByDateAndUser(date, user);
    }

    public List<DailyRoutine> findByUser(User user) {
        return repository.findByUser(user);
    }

    public DailyRoutine findByDateAndUser(Date date, User user) {
        return repository.findByDateAndUser(date, user);
    }

}
