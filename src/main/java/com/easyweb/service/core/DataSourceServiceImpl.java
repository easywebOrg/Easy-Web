package com.easyweb.service.core;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
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

    /**
     * 将系统需要用到的数据库进行创建
     * <p>
     * TODO 数据库创将字段顺序跟类中定义顺序不同
     * TODO 注释未写入数据库
     */
    public void createSysDB() {
        ClassPathResource ac = new ClassPathResource(DEFAULT_DATASOURCE_CONFIG_FILE_PATH);
        XmlBeanFactory xbf = new XmlBeanFactory(ac);
//        注意： &sessionFactory ，一定要包含 & ，不加Spring返回的是Hibernate下的SessionFactoryImpl类
        LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) xbf.getBean("&sessionFactory");
        Configuration cfg = lsfb.getConfiguration();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, false);
    }
}
