package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.MealForDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealForDayRepository extends JpaRepository<MealForDay, Long> {
}
