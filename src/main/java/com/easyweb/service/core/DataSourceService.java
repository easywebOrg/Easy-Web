package com.easyweb.service.core;

public interface DataSourceService {
    public static final String DEFAULT_DATASOURCE_CONFIG_FILE_PATH = "../spring/default-datasource.xml";

    /**
     * 默认数据源是否可用
     *
     * @return true为可用
     */
    public boolean isDefaultDataSourceConnectable();
}
