package com.easyweb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ddlExecutorDao")
public class DdlExecutorDaoImpl implements DdlExecutorDao {
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public void executeDdl(String ddl) {
//        sessionFactory.getCurrentSession().createSQLQuery(ddl);
    }
}
