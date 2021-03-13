package com.demo.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author 陈龙
 * @creatTime 2021/2/22 11:46
 * @describe
 */
public class CGLIBDynamicProxy {

    @Test
    public void test(){
        //cglib是通过生成代理类继承
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Subject.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Subject subject= (Subject) enhancer.create();
        subject.doSomething();
    }
}
