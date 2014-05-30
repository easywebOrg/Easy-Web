package com.easyweb.entity.core;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 模块信息，用于区分一个系统内，多个不同模块
 */
@Entity
@Table(name = "t_module_info")
public class ModuleInfo {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 模块名称
     */
    @Column(length = 31, name = "module_name")
    private String moduleName;

    /**
     * 模块描述
     */
    @Column(length = 63, name = "module_desc")
    private String moduleDesc;

    /**
     * 对应系统信息
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="system_info_id")
    private SystemInfo systemInfo;

    /**
     * 父模块信息
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private ModuleInfo parentModuleInfo;

    /**
     * 子模块信息
     */
    @OneToMany(targetEntity = ModuleInfo.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentModuleInfo")
    @Fetch(FetchMode.JOIN)
    @OrderBy("moduleName")
    private List<ModuleInfo> childModules;

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public ModuleInfo getParentModuleInfo() {
        return parentModuleInfo;
    }

    public void setParentModuleInfo(ModuleInfo parentModuleInfo) {
        this.parentModuleInfo = parentModuleInfo;
    }

    public List<ModuleInfo> getChildModules() {
        return childModules;
    }

    public void setChildModules(List<ModuleInfo> childModules) {
        this.childModules = childModules;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }
}
