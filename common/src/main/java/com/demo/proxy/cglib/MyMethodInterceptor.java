package com.demo.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 陈龙
 * @creatTime 2021/2/22 11:42
 * @describe
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o cglib生成的代理对象
     * @param method 被代理对象方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy execute before!");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("proxy execute after!");
        return object;
    }
}
