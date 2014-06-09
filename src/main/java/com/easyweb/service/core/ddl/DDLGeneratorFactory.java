package com.easyweb.service.core.ddl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Scope("singleton")
@Service("ddlGeneratorFactory")
public class DdlGeneratorFactory {
    private static Map<String, DdlGenerator> keyWordMap = new HashMap<>();

    public void registerGenerator(DdlGenerator ddlGenerator) {
        keyWordMap.put(ddlGenerator.getGeneratorDialect(), ddlGenerator);
    }

    public DdlGenerator getDdlGenerator(String dialect) {
        DdlGenerator ddlGenerator = keyWordMap.get(dialect);
        if (null == ddlGenerator) {
            throw new RuntimeException(String.format("dialect: [%s] not exist！", dialect));
        } else {
            return ddlGenerator;
        }
    }
}
