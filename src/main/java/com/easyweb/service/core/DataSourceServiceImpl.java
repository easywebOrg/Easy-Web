package com.easyweb.service.core;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {
    @Override
    public boolean isDefaultDataSourceConnectable() {

        ClassPathResource ac = new ClassPathResource(DEFAULT_DATASOURCE_CONFIG_FILE_PATH);
        XmlBeanFactory xbf = new XmlBeanFactory(ac);
//        注意： &sessionFactory ，一定要包含 & ，不加Spring返回的是Hibernate下的SessionFactoryImpl类
        LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) xbf.getBean("&sessionFactory");
        return false;
    }
}
