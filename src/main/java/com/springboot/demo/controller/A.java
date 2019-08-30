package com.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 陈龙
 * @Date: 2019/8/30 11:48
 * @Version 1.0
 * @Function:
 */
@RestController
@Slf4j
public class A {
    @GetMapping("test")
    private String test(){
        log.info("123");
        return "test";
    }
}
