package com.hescha.trainingdaily.repository;

import com.hescha.trainingdaily.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsernameIgnoreCase(String username);

    public User findByUsername(String username);
}
