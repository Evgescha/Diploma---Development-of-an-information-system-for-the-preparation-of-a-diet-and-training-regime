package com.hescha.trainingdaily.controller;

import com.hescha.trainingdaily.model.AbstractEntity;
import com.hescha.trainingdaily.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractController<E extends AbstractEntity> {

    protected final CrudService<E> service;
    protected final String pagePath;

    public String getPage(Model model) {
        List<E> list = service.findAll();
        model.addAttribute("list", list);
        return pagePath + "-list";
    }

    public abstract String editOrNewPage(Model model, @PathVariable(name = "id", required = false) Long id);

    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/" + pagePath;
    }

    public String createOrUpdate(E e) {
        E created = service.create(e);
        return "redirect:/" + pagePath;
    }
}
