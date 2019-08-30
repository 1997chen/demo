package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 陈龙
 * @Date: 2019/7/26 14:00
 * @Version 1.0
 * @Function:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //访问地址：http://项目实际地址/swagger-ui.html
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("小蜗商城API")
                .description("更多信息联系作者")
                .termsOfServiceUrl("http://localhost:8080/")
                .contact(new Contact("陈龙","http://localhost:8080/","1944226244@qq.com"))
                .version("0.1")
                .build();
    }

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chen.springdemo.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
