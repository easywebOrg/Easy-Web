package com.easyweb.service.core.ddl;

import com.easyweb.entity.core.Model;
import com.easyweb.entity.core.ModelProperty;

import javax.annotation.Resource;
import java.util.Collection;

public class DdlGeneratorMySql extends AbstractDdlGenerator {
    @Resource
    private DdlGeneratorFactory ddlGeneratorFactory;

    @Override
    public void registerGenerator() {
        ddlGeneratorFactory.registerGenerator(this);
    }

    @Override
    public String getGeneratorDialect() {
        return "mysql";
    }

    @Override
    public String generateCreateDDL(Model model) {
        StringBuilder ddl = new StringBuilder("CREATE TABLE ");
        ddl.append("`").append(model.getModelName()).append("` (");

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
        return "`" + modelProperty.getPropertyName() + "` " + modelProperty.getColumnType();
    }
}
