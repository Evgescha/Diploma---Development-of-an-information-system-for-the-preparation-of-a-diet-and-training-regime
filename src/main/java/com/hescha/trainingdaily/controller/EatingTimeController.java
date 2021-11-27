package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.EatingTime;
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
@RequestMapping("/eatingTimes")
public class EatingTimeController extends AbstractController<EatingTime> {

    private final static String pagePath = "eatingTimes";

    public EatingTimeController(CrudService<EatingTime> service) {
        super(service, EatingTimeController.pagePath);
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
        EatingTime entity = (id == null) ? new EatingTime() : service.read(id);
        model.addAttribute("entity", entity);
        return pagePath + "-one";
    }

    @RequestMapping(path = "/create", method = POST)
    public String createOrUpdate(EatingTime e) {
        return super.createOrUpdate(e);
    }
}
