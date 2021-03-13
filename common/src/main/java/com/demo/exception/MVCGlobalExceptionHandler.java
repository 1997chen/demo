package com.demo.exception;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 陈龙
 * @Date: 2019/7/26 10:00
 * @Version 1.0
 * @Function:
 */
//@ControllerAdvice
public class MVCGlobalExceptionHandler {
    //@ExceptionHandler(value = Exception.class)
    private String globalException(HttpServletRequest request, HttpServletResponse response, Model model, Exception e) {
        model.addAttribute("cause","异常：" + e);
        model.addAttribute("exceptionMsg","异常：" +e.getStackTrace()[0]);
        model.addAttribute("url","url：" + request.getRequestURI());
        response.setStatus(500);
        model.addAttribute("code",response.getStatus());
        return "fail";
    }
}
