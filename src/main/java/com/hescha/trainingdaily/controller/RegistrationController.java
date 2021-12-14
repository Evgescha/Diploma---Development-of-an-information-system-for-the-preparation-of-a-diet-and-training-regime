package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registrationPage(Model model, @ModelAttribute User user) {
        boolean success = userService.registerNew(user);
        String response = success
                ? "Успешно зарегистрирован"
                : "Ошибка регистрации. Попробуйте позже.";
        model.addAttribute("success", response);
        return "login";
    }

    @GetMapping
    public String getRegistration() {
        return "login";
    }

}
