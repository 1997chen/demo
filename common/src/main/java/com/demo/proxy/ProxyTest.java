package com.demo.proxy;

import org.junit.Test;

/**
 * @author 陈龙
 * @creatTime 2021/2/19 9:53
 * @describe
 */
public class ProxyTest {

    @Test
    public void jdkProxyTest(){
        Subject subject = new JDKDynamicProxy(new SubjectImpl()).getProxy();
        subject.doSomething();
    }
}
