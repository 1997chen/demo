package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 陈龙
 * @creatTime 2021/2/23 10:34
 * @describe
 */
@Component
public class LifeCycle implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getName()+"bean init before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getName() + "bean init after");
        return null;
    }

    @PostConstruct()
    public void a(){
        System.out.println("LifeCycle");
    }

}
