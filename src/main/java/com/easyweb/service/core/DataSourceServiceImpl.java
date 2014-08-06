package com.easyweb.service.core;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {
    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public String testDefaultDataSourceConnectable() {
        String result = null;
        Connection connection = null;
        try {
            final ProxoolXmlConfigurator proxoolXmlConfigurator = getProxoolXmlConfigurator();

            Class.forName(proxoolXmlConfigurator.getDriverClass());

            Properties properties = new Properties();
            properties.put("user", proxoolXmlConfigurator.getUser());
            properties.put("password", proxoolXmlConfigurator.getPassword());
            properties.put("connectTimeout", "2000");

            connection = DriverManager.getConnection(proxoolXmlConfigurator.getDriverUrl(), properties);
            connection.isValid(1);
        } catch (Exception e) {
            result = e.getMessage();
            log.debug(e.getMessage(), e);
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    @Override
    public ProxoolXmlConfigurator getProxoolXmlConfigurator() {
        try {
            ClassPathResource ac = new ClassPathResource(DEFAULT_PROXOOL_CONFIG_FILE_PATH);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            ProxoolXmlConfigurator proxoolXmlConfigurator = new ProxoolXmlConfigurator();
            xmlReader.setErrorHandler(proxoolXmlConfigurator);
            saxParser.parse(ac.getFile(), proxoolXmlConfigurator);

            return proxoolXmlConfigurator;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
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
