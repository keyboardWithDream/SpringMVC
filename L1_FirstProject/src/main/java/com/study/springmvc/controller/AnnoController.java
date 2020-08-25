package com.study.springmvc.controller;

import com.study.springmvc.domain.Account;
import com.study.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020-8-25 下午 4:07
 * 常用注解
 */
@Controller
@SessionAttributes({"msg"})
@RequestMapping(path = "/anno")
public class AnnoController {

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name", required = false) String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping(path = "testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("account") Account account){
        System.out.println("testModelAttribute方法执行了...");
        System.out.println(account);
        return "success";
    }

    @ModelAttribute
    public Account showUser(String username, Map<String, Account> map){
        System.out.println("showUser方法执行了...");
        //模拟查询数据库
        Account account = new Account();
        User user = new User();
        user.setUname("uname");
        user.setAge(20);
        user.setDate(new Date());
        account.setUser(user);
        map.put("account", account);
        return account;
    }

    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Model model){
        model.addAttribute("msg", "Hello World!");
        return "success";
    }
}
