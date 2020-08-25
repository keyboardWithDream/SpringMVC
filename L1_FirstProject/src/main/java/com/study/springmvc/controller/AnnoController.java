package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Harlan
 * @date 2020-8-25 下午 4:07
 * 常用注解
 */
@Controller
@RequestMapping(path = "/anno")
public class AnnoController {

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name", required = false) String username){
        System.out.println(username);
        return "success";
    }
}
