package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    String get(Model model) {
        List<User> list = service.findAll();
        model.addAttribute("list", list);
        return "users";
    }

    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String edit(Model model, @PathVariable(name = "id", required =
            false) Long id) {
        if (id != null) {
            User entity = service.read(id);
            model.addAttribute("entity", entity);
        } else {
            model.addAttribute("entity", new User());
        }
        return "users-one";
    }

    @PostMapping(path = "/create")
    public String createOrUpdate(User entity) {
        if (entity.getId() == null)
            service.registerNew(entity);
        else {
            User read = service.read(entity.getId());
            read.setFio(entity.getFio());
            read.setEmail(entity.getEmail());
            read.setDateBorn(entity.getDateBorn());
            read.setPassword(passwordEncoder.encode(entity.getPassword()));
            service.update(read);
        }
        return "redirect:/users";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/users";
    }

}
