package com.demo;

import com.demo.bean.LifeCycle;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.springboot.com.demo.mapper")
@EnableTransactionManagement
public class DemoApplication {

    @Autowired
    private LifeCycle lifeCycle;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
