package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.Meal;
import com.hescha.trainingdaily.model.Product;
import com.hescha.trainingdaily.service.CrudService;
import com.hescha.trainingdaily.service.ProductService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/meals")
public class MealController extends AbstractController<Meal> {

    private final static String pagePath = "meals";

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public MealController(CrudService<Meal> service) {
        super(service, MealController.pagePath);
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
        Meal entity = (id == null) ? new Meal() : service.read(id);
        model.addAttribute("entity", entity);
        model.addAttribute("list", productService.findAll());

        return pagePath + "-one";
    }

    @RequestMapping(path = "/create", method = POST)
    public String createOrUpdate(
            Meal e,
            @RequestParam("products") Map<Long, Integer> products,
            Principal principal) {
        if (e.getAddedBy() == null) {
            e.setAddedBy(userService.findByUsername(principal.getName()));
            e = service.create(e);
        } else {
            e = service.update(e);
        }
        e.getFoods().clear();


        Map<Product, Integer> myProducts = products.entrySet()
                .stream()
                .collect(Collectors.toMap(el -> productService.read(el.getKey()),
                        el -> el.getValue(),
                        (existing, replacement) -> existing));

        e.setFoods(myProducts);

        return "redirect:/" + pagePath;
    }
}
