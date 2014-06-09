package com.easyweb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring-mvc-test.xml",
        "classpath:spring/spring-common-test.xml",
        "classpath:spring/default-datasource-test.xml"})
public class AbstractContextControllerTests {
    @Autowired
    protected WebApplicationContext wac;
}
