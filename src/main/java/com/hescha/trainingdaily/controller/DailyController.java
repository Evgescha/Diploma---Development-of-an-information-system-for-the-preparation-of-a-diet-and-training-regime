package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.DailyRoutine;
import com.hescha.trainingdaily.model.EatingTime;
import com.hescha.trainingdaily.model.Exercise;
import com.hescha.trainingdaily.model.MealForDay;
import com.hescha.trainingdaily.model.Product;
import com.hescha.trainingdaily.model.User;
import com.hescha.trainingdaily.service.DailyRoutineService;
import com.hescha.trainingdaily.service.EatingTimeService;
import com.hescha.trainingdaily.service.ExerciseService;
import com.hescha.trainingdaily.service.MealForDayService;
import com.hescha.trainingdaily.service.ProductService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/daily")
public class DailyController {

    @Autowired
    private DailyRoutineService service;

    @Autowired
    private UserService userService;

    @Autowired
    private EatingTimeService eatingTimeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MealForDayService mealForDayService;

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public String get(Model model,
                      Principal principal,
                      @Param(value = "strDate") String strDate) {
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
        if (service.isExistsByDateAndUser(date, user)) {
            return "redirect:/daily/" + service.findByDateAndUser(date, user).getDate().toString();
        }
        entity.setDate(date);
        entity.setUser(user);

        service.create(entity);

        return "redirect:/daily?strDate=" + date.toString();
    }

    @PostMapping
    public String addProductPage(@RequestParam(value = "time") Long time,
                                 @RequestParam(value = "daily") Long daily,
                                 Model model) {
        EatingTime eatingTime = eatingTimeService.read(time);
        List<Product> products = productService.findAll();

        model.addAttribute("dailyId", daily);
        model.addAttribute("eatingTime", eatingTime);
        model.addAttribute("products", products);

        return "daily-add-product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam(value = "time") Long time,
                             @RequestParam(value = "daily") Long daily,
                             @RequestParam(value = "product") Long product,
                             @RequestParam(value = "count") Integer count) {
        DailyRoutine entity = service.read(daily);
        Product product1 = productService.read(product);
        EatingTime eatingTime = eatingTimeService.read(time);

        MealForDay mealForDay;
        List<MealForDay> collect = entity.getMealForDays().stream()
                .filter(meal -> meal.getTime().getId() == eatingTime.getId())
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            mealForDay = new MealForDay();
            mealForDay.setTime(eatingTime);
            mealForDay.setDailyRoutine(entity);

            mealForDay = mealForDayService.create(mealForDay);
            entity.getMealForDays().add(mealForDay);
            entity = service.update(entity);

            mealForDay = entity.getMealForDays().stream()
                    .filter(meal -> meal.getTime().getId() == eatingTime.getId())
                    .collect(Collectors.toList()).get(0);
        } else {
            mealForDay = collect.get(0);
        }

        mealForDay.getProducts().put(product1, count);
        mealForDayService.update(mealForDay);

        return "redirect:/daily?strDate=" + entity.getDate().toString();
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "time") Long time,
                                @RequestParam(value = "daily") Long daily,
                                @RequestParam(value = "product") Long product) {
        DailyRoutine entity = service.read(daily);
        Product product1 = productService.read(product);
        EatingTime eatingTime = eatingTimeService.read(time);

        List<MealForDay> collect = entity.getMealForDays().stream()
                .filter(meal -> meal.getTime().getId() == eatingTime.getId())
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            return "redirect:/daily?strDate=" + entity.getDate().toString();
        }

        MealForDay meal = collect.get(0);
        if (meal.getProducts().containsKey(product1)) {
            meal.getProducts().remove(product1);
            mealForDayService.update(meal);
        }
        return "redirect:/daily?strDate=" + entity.getDate().toString();
    }


    @PostMapping("/exercisePage")
    public String exercisePage(@RequestParam(value = "daily") Long daily,
                               Model model) {
        List<Exercise> exercises = exerciseService.findAll();

        model.addAttribute("dailyId", daily);
        model.addAttribute("exercises", exercises);

        return "daily-add-exercise";
    }

    @PostMapping("/addExercise")
    public String addExercise(@RequestParam(value = "daily") Long daily,
                              @RequestParam(value = "exercise") Long exercise,
                              @RequestParam(value = "count") Integer count) {
        DailyRoutine entity = service.read(daily);
        Exercise exercise1 = exerciseService.read(exercise);

        entity.getExercises().put(exercise1, count);
        service.update(entity);

        return "redirect:/daily?strDate=" + entity.getDate().toString();
    }

    @PostMapping("/deleteExercise")
    public String deleteProduct(@RequestParam(value = "daily") Long daily,
                                @RequestParam(value = "exercise") Long exercise) {
        DailyRoutine entity = service.read(daily);
        Exercise exercise1 = exerciseService.read(exercise);

        if (entity.getExercises().containsKey(exercise1)) {
            entity.getExercises().remove(exercise1);
            service.update(entity);
        }

        return "redirect:/daily?strDate=" + entity.getDate().toString();
    }


    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/daily";
    }

}
