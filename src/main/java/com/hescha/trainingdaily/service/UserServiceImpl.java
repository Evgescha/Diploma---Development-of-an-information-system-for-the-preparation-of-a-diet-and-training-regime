package com.hescha.trainingdaily.service;

import com.hescha.trainingdaily.model.Role;
import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudImpl<User> {

    private final static String DEFAULT_ROLE = "ROLE_USER";
    private final static String ROLE_ADMIN = "ROLE_ADMIN";

    private RoleService roleService;
	private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return repository.findByUsernameIgnoreCase(username);
    }

    public boolean registerNew(User entity) {

        if (repository.findByUsernameIgnoreCase(entity.getUsername()) != null)
            return false;
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        try {
            if (roleService.findByName(DEFAULT_ROLE) == null)
                roleService.create(new Role(DEFAULT_ROLE));
            // просто создание
            create(entity);

            // добавление роли и сохранение
            Role role = roleService.findByName(DEFAULT_ROLE);
            entity = repository.findByUsernameIgnoreCase(entity.getUsername());
            entity.setRole(role);
            update(entity);

            // сохранение в списке ролей пользователя
            role.getUsers().add(entity);
            roleService.update(role);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
