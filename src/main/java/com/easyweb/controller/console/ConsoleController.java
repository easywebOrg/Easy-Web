package com.easyweb.controller.console;

import com.easyweb.service.core.DataSourceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ConsoleController {
    private Logger log = Logger.getLogger(this.getClass());

    @Resource
    private DataSourceService dataSourceService;

    @RequestMapping("/console")
    public @ResponseBody
    String consoleIndex() {
        return dataSourceService.testDefaultDataSourceConnectable();
    }
}
