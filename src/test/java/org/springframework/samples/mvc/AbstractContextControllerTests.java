package org.springframework.samples.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(
        locations={
        "file:src/test/resources/spring/spring-common.xml",
        "file:src/test/resources/spring/spring-mvc.xml"
        }
)
public class AbstractContextControllerTests {
	@Autowired
	protected WebApplicationContext wac;

}
