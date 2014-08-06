package com.easyweb.controller.console;

import com.easyweb.service.core.DataSourceService;
import com.easyweb.service.core.ProxoolXmlConfigurator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/console")
public class ConsoleController {
    private Logger log = Logger.getLogger(this.getClass());

    @Resource
    private DataSourceService dataSourceService;

    @RequestMapping
    public String index(ModelMap modelMap) {
        String errorMsg = dataSourceService.testDefaultDataSourceConnectable();
        if (StringUtils.isBlank(errorMsg)) {
            modelMap.put("message", "数据连接成功！TODO...");
        } else {
            ProxoolXmlConfigurator conf = dataSourceService.getProxoolXmlConfigurator();
            modelMap.put("message", String.format("数据库连接失败！请确认连接名:[%s],  URL:[%s], 用户名:[%s], 密码:[%s] 是否正确"
                    , conf.getPoolName(), conf.getDriverUrl(), conf.getUser(), conf.getPassword()));
        }

        return "console/index";
    }
}
