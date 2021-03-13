package com.demo.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 陈龙
 * @creatTime 2021/2/23 16:12
 * @describe
 */
public class MyFactoryBean implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
