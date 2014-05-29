package com.easyweb.controller.console;

import com.easyweb.service.core.DataSourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ConsoleController {
    @Resource
    private DataSourceService dataSourceService;

    @RequestMapping("/console")
    public @ResponseBody
    String consoleIndex() {
        dataSourceService.isDefaultDataSourceConnectable();
        return "Create DB Success!";
    }
}
