package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.EatingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatingTimeRepository extends JpaRepository<EatingTime, Long> {
}
