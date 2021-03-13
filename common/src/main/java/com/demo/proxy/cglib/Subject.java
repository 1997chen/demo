package com.demo.proxy.cglib;

/**
 * @author 陈龙
 * @creatTime 2021/2/22 11:40
 * @describe cglib代理的类不能是final的，且方法也不能是final
 */

public class Subject {

    public void doSomething(){
        System.out.println("do !!!");
    }
}
