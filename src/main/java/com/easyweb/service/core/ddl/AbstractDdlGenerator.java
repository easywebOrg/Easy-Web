package com.easyweb.service.core.ddl;

import javax.annotation.PostConstruct;

public abstract class AbstractDdlGenerator implements DdlGenerator {
    @PostConstruct
    @Override
    public abstract void registerGenerator();
}
