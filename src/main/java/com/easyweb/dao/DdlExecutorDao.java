package com.easyweb.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;

/**
 * 执行ddl语句
 */
public interface DdlExecutorDao {
    public void executeDdl(String ddl);
}
