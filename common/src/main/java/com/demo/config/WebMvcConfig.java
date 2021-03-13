package com.demo.config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: 陈龙
 * @Date: 2019/7/20 16:36
 * @Version 1.0
 * @Function:
 */

//@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true);
        configurer.setUseRegisteredSuffixPatternMatch(true);
        super.configurePathMatch(configurer);
    }

  /*  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view/**").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/image/**").addResourceLocations("/static/image/");
        registry.addResourceHandler("/layui/**").addResourceLocations("classpath:/static/layui/*");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    }*/
}
