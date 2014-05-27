package com.easyweb.service.core;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

@Service("modelService")
public class ModelServiceImpl implements ModelService {
    public String createDB() {

        ClassPathResource ac = new ClassPathResource("../spring/spring-common.xml");
        XmlBeanFactory xbf = new XmlBeanFactory(ac);
//        注意： &sessionFactory ，一定要包含 & ，不加Spring返回的是Hibernate下的SessionFactoryImpl类
        LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) xbf.getBean("&sessionFactory");
        Configuration cfg = lsfb.getConfiguration();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, false);
        return null;
    }
}
