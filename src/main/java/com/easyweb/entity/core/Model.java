package com.easyweb.entity.core;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 模型信息，主要用于持久化数据的建模，模型生成对应表
 */
@Entity
@Table(name = "t_model")
public class Model {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 模型名称
     */
    @Column(length = 31, name = "model_name")
    private String modelName;

    /**
     * 模型描述
     */
    @Column(length = 63, name = "model_desc")
    private String modelDesc;

    /**
     * 对应模块信息
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="module_info_id")
    private ModuleInfo moduleInfo;

    /**
     * 最后更新时间，同时用于乐观锁
     */
    @Version
    @Column(name = "last_update")
    private Date lastUpdate;

    /**
     * 模型属性关联
     */
    @OneToMany(cascade = {CascadeType.ALL})
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "model_id")
    private List<ModelProperty> modelProperties;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<ModelProperty> getModelProperties() {
        return modelProperties;
    }

    public void setModelProperties(List<ModelProperty> modelProperties) {
        this.modelProperties = modelProperties;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }
}
