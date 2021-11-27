package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.Product;
import com.hescha.trainingdaily.service.CrudService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/products")
public class ProductController extends AbstractController<Product> {

    private final static String pagePath = "products";

    @Autowired
    private UserService userService;

    public ProductController(CrudService<Product> service) {
        super(service, ProductController.pagePath);
    }

    @GetMapping
    @Override
    public String getPage(Model model) {
        return super.getPage(model);
    }

    @RequestMapping(path = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"}, method = RequestMethod.GET)
    @Override
    public String editOrNewPage(Model model, Long id) {
        Product entity = (id == null) ? new Product() : service.read(id);
        model.addAttribute("entity", entity);
        return pagePath + "-one";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createOrUpdate(Product e, Principal principal) {
        if (e.getAddedBy() == null) {
            e.setAddedBy(userService.findByUsername(principal.getName()));
            e = service.create(e);
        } else {
            e = service.update(e);
        }
        return "redirect:/" + pagePath + "/" + e.getId();
    }
}
