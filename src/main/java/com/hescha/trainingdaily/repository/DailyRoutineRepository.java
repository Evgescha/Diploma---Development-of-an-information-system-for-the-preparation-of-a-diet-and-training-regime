package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.DailyRoutine;
import com.hescha.trainingdaily.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DailyRoutineRepository extends JpaRepository<DailyRoutine, Long> {
    boolean existsByDateAndUser(Date date, User user);

    List<DailyRoutine> findByUser(User user);

    DailyRoutine findByDateAndUser(Date date, User user);
}
