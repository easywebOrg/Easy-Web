package com.easyweb.entity.core;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_model")
public class Model {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模型名称
     */
    @Column(length=32, name = "model_name")
    private String modelName;

    /**
     * 模型描述
     */
    @Column(length=64, name = "model_desc")
    private String modelDesc;

    /**
     * 最后更新时间，同时用于乐观锁
     */
    @Version
    @Column(name="last_update")
    private Date lastUpdate;

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
}
