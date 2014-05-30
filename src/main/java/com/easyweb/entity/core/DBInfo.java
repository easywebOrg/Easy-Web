package com.easyweb.entity.core;

import javax.persistence.*;
import java.util.Date;

/**
 * 数据库连接信息，主要用于保存数据持久化的数据库
 */
@Entity
@Table(name = "t_db_info")
public class DBInfo {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 数据库名
     */
    @Column(length = 31, name = "db_name")
    private String dbName;

    /**
     * 数据库类型，mysql、oracle、mssql等
     */
    @Column(length = 1, name = "db_type")
    private String dbType;

    /**
     * 数据库连接串
     */
    @Column(length = 127, name = "connection_url")
    private String connectionURL;

    /**
     * 数据库连接属性
     */
    @Column(length = 1023, name = "db_properties")
    private String dbProperties;

    /**
     * 数据库连接用户名
     */
    @Column(length = 63, name = "user_name")
    private String userName;

    /**
     * 数据库连接密码
     */
    @Column(length = 1023, name = "password")
    private String password;

    /**
     * 数据库连接策略
     */
    @Column(length = 1023, name = "connection_strategies")
    private String connectionStrategies;

    /**
     * 最后更新时间，同时用于乐观锁
     */
    @Version
    @Column(name = "last_update")
    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getDbProperties() {
        return dbProperties;
    }

    public void setDbProperties(String dbProperties) {
        this.dbProperties = dbProperties;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionStrategies() {
        return connectionStrategies;
    }

    public void setConnectionStrategies(String connectionStrategies) {
        this.connectionStrategies = connectionStrategies;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
