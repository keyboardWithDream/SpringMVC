package com.study.springmvc.controller;

import com.study.springmvc.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Harlan
 * @Date 2020/9/8
 */
@Controller
@RequestMapping("/test")
public class ExceptionController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }

    @RequestMapping("/noException")
    public String noException(){
        System.out.println("异常不处理...");
        int error = 1 / 0;
        return "success";
    }

    @RequestMapping("/doException")
    public String doException() throws SysException {
        System.out.println("处理异常...");
        try {
            int error = 1 / 0;
        } catch (Exception e) {
            System.out.println("出现异常...");
            //抛出自定义异常信息
            throw new SysException("除数不能为零!");
        }
        return "success";
    }
}
