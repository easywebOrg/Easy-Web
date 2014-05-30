package com.easyweb.entity.core;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统信息，用于区分一套环境内多系统的发布
 */
@Entity
@Table(name = "t_system_info")
public class SystemInfo {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 系统名称
     */
    @Column(length = 31, name = "system_name")
    private String systemName;

    /**
     * 系统描述
     */
    @Column(length = 63, name = "system_desc")
    private String systemDesc;

    /**
     * 数据库连接信息，用于指定系统所在数据库
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "db_info_id")
    private DBInfo dbInfo;

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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemDesc() {
        return systemDesc;
    }

    public void setSystemDesc(String systemDesc) {
        this.systemDesc = systemDesc;
    }

    public DBInfo getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
