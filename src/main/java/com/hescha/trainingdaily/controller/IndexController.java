package com.hescha.trainingdaily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final static String pagePath = "index";

    @GetMapping
    public String getPage(Model model) {
        return pagePath;
    }

}
