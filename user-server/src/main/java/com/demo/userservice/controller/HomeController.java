package com.demo.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈龙
 * @creatTime 2021/3/13 14:44
 * @describe
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public void home(){
        for (int i = 0; i<1000;i++){
           String s = new String("阿萨达撒孙菲菲gas克己奉公卡是个坑kgask"+i);
        }
    }
}
