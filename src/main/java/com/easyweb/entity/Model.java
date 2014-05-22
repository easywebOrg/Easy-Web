package com.easyweb.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "t_model")
public class Model {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(length = 32)
    private String modelName;

//    @Column(length = 64)
    private String modelDesc;

//    @Version
//    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
