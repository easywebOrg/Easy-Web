package com.easyweb.service.core;

import com.easyweb.entity.core.Model;

/**
 * 模型-数据库表 处理器
 */
public interface ModelTableResolver {
    /**
     *
     * 根据Model生成表
     *
     * @param model 模型信息
     * @param dialect 数据库方言
     *
     * @return 执行操作的DDL语句
     */
    public String createTable(Model model, String dialect);
}
