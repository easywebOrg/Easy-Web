package com.easyweb.controller.core;

import javax.annotation.Resource;

import com.easyweb.service.core.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelController {
	@Resource
	private ModelService modelService;

    @RequestMapping("/model")
    public @ResponseBody String createModel() {
        modelService.createDB();
        return "Hello world!";
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}