package com.study.springmvc.controller;

import com.study.springmvc.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Harlan
 * @date 2020-8-23 下午 7:26
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {



    @RequestMapping(path = "/testParam")
    public String testParam(String username, String password){
        System.out.println("测试参数绑定");
        System.out.println(username + "---" + password);
        return "success";
    }

    @RequestMapping(path = "/save")
    public String save(Account account){
        System.out.println(account);
        return "success";
    }
}
