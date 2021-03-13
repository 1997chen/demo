package com.demo.proxy;

/**
 * @author 陈龙
 * @creatTime 2021/2/18 17:26
 * @describe
 */
public class SubjectImpl implements Subject {
    @Override
    public void doSomething() {
        System.out.println("do!!!");
    }
}
