package com.easyweb.test.core;

import com.easyweb.entity.core.Model;
import com.easyweb.test.AbstractContextControllerTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.form.FormController;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class ModelControllerTests extends AbstractContextControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = standaloneSetup(new FormController()).setViewResolvers(viewResolver).build();
    }

    @Test
    public void modelDDL() throws Exception {
        Model model = new Model();
        model.setModelName("test");

        this.mockMvc.perform(
                post("/model/ddl")
                        .param("model.modelName", "testModel")
                        .param("model.modelProperties[0].propertyName", "propertyVar")
                        .param("model.modelProperties[0].columnType", "varchar(31)")
                        .param("model.modelProperties[1].propertyName", "propertyInt")
                        .param("model.modelProperties[1].columnType", "INT(10)")
                        .param("model.modelProperties[2].propertyName", "propertyFloat")
                        .param("model.modelProperties[2].columnType", "FLOAT")
                        .param("model.modelProperties[3].propertyName", "propertyTS")
                        .param("model.modelProperties[3].columnType", "TIMESTAMP")
        )
                .andDo(print());
    }
}
