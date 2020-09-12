package com.study.springmvc.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor执行了...");
        return "success";
    }
}
