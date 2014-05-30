package com.easyweb.service.core;

import com.easyweb.entity.core.Model;
import com.easyweb.entity.core.ModelProperty;

import java.util.Collection;

public class GenerateDDLServiceImpl implements GenerateDDLService {
    /**
     * 根据Model生成DDL
     *
     * @param model 模型信息
     * @return DDL
     */
    @Override
    public String generateCreateDDL(Model model) {
        StringBuilder ddl = new StringBuilder("CREATE TABLE ");
        ddl.append(model.getModelName()).append(" (");

        Collection properties = model.getModelProperties();
        for(Object o : properties) {
            ModelProperty modelProperty = (ModelProperty) o;
            ddl.append(getColumnDDL(modelProperty)).append(", ");
        }

        ddl.append("PRIMARY KEY (`id`));");

        return ddl.toString();
    }

    // 获取列的ddl语句
    private String getColumnDDL(ModelProperty modelProperty) {
        return "'" + modelProperty.getPropertyName() + "' " + modelProperty.getColumnType();
    }
}
