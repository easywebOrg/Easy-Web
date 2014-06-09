package com.easyweb.service.core.ddl;

import com.easyweb.entity.core.Model;

/**
 * DDL语句生成器
 */
public interface DdlGenerator {
    public void registerGenerator();

    /**
     * 获取生成器的方言
     *
     * @return 生成器方言
     */
    public String getGeneratorDialect();

    /**
     * 生成创建表的DDL语句
     *
     * @param model 模型信息
     * @return DDL语句
     */
    public String generateCreateDDL(Model model);
}
