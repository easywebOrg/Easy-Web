package com.easyweb.service.core;

import com.easyweb.entity.core.Model;

public interface GenerateDDLService {
    /**
     * 根据Model生成DDL
     *
     * @param model 模型信息
     * @return DDL
     */
    public String generateCreateDDL(Model model);
}
