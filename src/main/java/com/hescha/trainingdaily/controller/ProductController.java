package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.Exercise;
import com.hescha.trainingdaily.model.Product;
import com.hescha.trainingdaily.service.CrudService;
import com.hescha.trainingdaily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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

    @RequestMapping(path = "/delete/{id}", method = GET)
    @Override
    public String delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"}, method = GET)
    @Override
    public String editOrNewPage(Model model,  @PathVariable(value = "id", required = false) Long id) {
        Product entity = (id == null) ? new Product() : service.read(id);
        model.addAttribute("entity", entity);
        return pagePath + "-one";
    }

    @RequestMapping(path = "/approve/{id}", method = GET)
    public String approve(@PathVariable(value = "id", required = false) Long id) {
        Product read = service.read(id);
        read.setApproved(true);
        service.update(read);
        return "redirect:/" + pagePath;
    }

    @RequestMapping(path = "/create", method = POST)
    public String createOrUpdate(Product e, Principal principal) {
        if (e.getId() == null) {
            float kkalIn1 = e.getKkalIn100gr()/100;
            e.setKkalIn1gr(kkalIn1);
            e.setAddedBy(userService.findByUsername(principal.getName()));
            service.create(e);
        } else {
            Product inBase = service.read(e.getId());
            inBase.setImage(e.getImage());
            inBase.setName(e.getName());
            inBase.setDescription(e.getDescription());
            inBase.setKkalIn100gr(e.getKkalIn100gr());
            float kkalIn1 = e.getKkalIn100gr()/100;
            e.setKkalIn1gr(kkalIn1);
            service.update(inBase);
        }
        return "redirect:/" + pagePath;
    }
}
