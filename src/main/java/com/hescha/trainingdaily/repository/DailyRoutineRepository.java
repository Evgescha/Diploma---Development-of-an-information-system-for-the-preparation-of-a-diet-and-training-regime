package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.DailyRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyRoutineRepository extends JpaRepository<DailyRoutine, Long> {
}
