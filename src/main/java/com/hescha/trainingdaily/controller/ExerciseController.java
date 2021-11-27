package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.Exercise;
import com.hescha.trainingdaily.service.CrudService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/exercises")
public class ExerciseController extends AbstractController<Exercise> {

    private final static String pagePath = "exercises";

    @Autowired
    private UserService userService;

    public ExerciseController(CrudService<Exercise> service) {
        super(service, ExerciseController.pagePath);
    }

    @GetMapping
    @Override
    public String getPage(Model model) {
        return super.getPage(model);
    }

    @RequestMapping(path = "/delete/{id}", method = GET)
    @Override
    public String delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"}, method = GET)
    @Override
    public String editOrNewPage(Model model, Long id) {
        Exercise entity = (id == null) ? new Exercise() : service.read(id);
        model.addAttribute("entity", entity);
        return pagePath + "-one";
    }

    @RequestMapping(path = "/create", method = POST)
    public String createOrUpdate(Exercise e, Principal principal) {
        if (e.getAddedBy() == null) {
            e.setAddedBy(userService.findByUsername(principal.getName()));
            e = service.create(e);
        } else {
            e = service.update(e);
        }
        return "redirect:/" + pagePath + "/" + e.getId();
    }
}
