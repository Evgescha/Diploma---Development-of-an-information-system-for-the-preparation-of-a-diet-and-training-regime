package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.DailyRoutine;
import com.hescha.trainingdaily.model.EatingTime;
import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.service.DailyRoutineService;
import com.hescha.trainingdaily.service.EatingTimeService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/daily")
public class DailyController {

    @Autowired
    private DailyRoutineService service;

    @Autowired
    private UserService userService;

    @Autowired
    private EatingTimeService eatingTimeService;

    @GetMapping(path = {"/get", "/get/{date}"})
    public String get(Model model,
               Principal principal,
               @PathVariable(value = "strDate", required = false) String strDate) {
        Date date;
        if (strDate != null && !strDate.equals("")) {
            date = Date.valueOf(strDate);
        } else {
            date = new Date(System.currentTimeMillis());
        }

        User user = userService.findByUsername(principal.getName());
        DailyRoutine entity = service.findByDateAndUser(date, user);
        List<DailyRoutine> datesList = service.findByUser(user);
        List<EatingTime> times = eatingTimeService.findAll();
        Collections.sort(times);

        model.addAttribute("date", date);
        model.addAttribute("entity", entity);
        model.addAttribute("datesList", datesList);
        model.addAttribute("times", times);

        return "daily";
    }

    @GetMapping(path = "/create/{strDate}")
    public String createOrUpdate(@PathVariable(value = "strDate") String strDate,
                                 Principal principal) {

        User user = userService.findByUsername(principal.getName());
        Date date;
        DailyRoutine entity = new DailyRoutine();

        if (strDate != null && !strDate.equals("")) {
            date = Date.valueOf(strDate);
        } else {
            date = new Date(System.currentTimeMillis());
        }

        entity.setDate(date);
        entity.setUser(user);

        service.create(entity);

        return "redirect:/daily/get/" + date.toString();
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/daily";
    }

}
