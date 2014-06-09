package com.easyweb.service.core;

public interface DataSourceService {
    /**
     * spring管理的默认数据源配置文件位置
     */
    public static final String DEFAULT_DATASOURCE_CONFIG_FILE_PATH = "../spring/default-datasource.xml";

    /**
     * proxool管理的默认数据源配置文件位置
     */
    public static final String DEFAULT_PROXOOL_CONFIG_FILE_PATH = "../conf/proxool.xml";

    /**
     * proxool管理的默认数据源名称
     */
    public static final String DEFAULT_PROXOOL_CONNECTION_NAME = "easyweb";

    /**
     * 默认数据源是否可用
     *
     * @return 连接失败原因，连接成功返回空
     */
    public String testDefaultDataSourceConnectable();

    /**
     * 将系统需要用到的数据库进行创建
     */
    public void createSysDB();
}
