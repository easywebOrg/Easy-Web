package com.easyweb.controller.core;

import com.easyweb.entity.core.Model;
import com.easyweb.service.core.ModelTableResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ModelController {
    @Resource
    private ModelTableResolver modelTableResolver;

    @RequestMapping("/model/ddl")
    @ResponseBody
    public String consoleIndex(@ModelAttribute Model model, String dialect) {
        return modelTableResolver.createTable(model, dialect);
    }
}