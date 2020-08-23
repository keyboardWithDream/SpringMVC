package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Harlan
 * @date 2020-8-23 下午 4:56
 * 控制器
 */
@Controller
@RequestMapping(path = "/controller")
public class HelloController {

    @RequestMapping(path = "/hello", method = {RequestMethod.GET, RequestMethod.POST}, params = {"hello", "who=SpringMVC"}, headers = {"User-Agent"})
    public String sayHello(){
        System.out.println("Hello SpringMVC!");
        return "success";
    }

    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
