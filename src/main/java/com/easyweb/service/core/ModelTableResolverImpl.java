package com.easyweb.service.core;

import com.easyweb.entity.core.Model;
import com.easyweb.service.core.ddl.DdlGenerator;
import com.easyweb.service.core.ddl.DdlGeneratorFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("generateDDLService")
public class ModelTableResolverImpl implements ModelTableResolver {
    @Resource
    private DdlGeneratorFactory ddlGeneratorFactory;

    @Override
    public String createTable(Model model, String dialect) {
        DdlGenerator ddlGenerator = ddlGeneratorFactory.getDdlGenerator(dialect);
        String ddl = ddlGenerator.generateCreateDDL(model);



        return ddl;
    }
}
