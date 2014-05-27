package com.easyweb.entity.core;

import javax.persistence.*;
import java.util.Date;

/**
 * 对应模型的属性信息，主要用于持久化数据的建模，模型属性生成对应表字段
 */
@Entity
@Table(name = "t_model_property")
public class ModelPorperty {
    /**
     * ID主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 对应模型信息主键ID
     */
    @Column(name = "model_id")
    private Integer modelId;

    /**
     * 属性名称
     */
    @Column(length = 31, name = "property_name")
    private String propertyName;

    /**
     * 属性类型
     * TODO 映射为枚举类型
     */
    @Column(length = 1, name = "property_type")
    private String propertyType;

    /**
     * 字段类型
     * TODO 映射为枚举类型
     */
    @Column(length = 1, name = "column_type")
    private String columnType;

    /**
     * 字段精度
     */
    @Column(length = 31, name = "column_precision")
    private String columnPrecision;

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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnPrecision() {
        return columnPrecision;
    }

    public void setColumnPrecision(String columnPrecision) {
        this.columnPrecision = columnPrecision;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
