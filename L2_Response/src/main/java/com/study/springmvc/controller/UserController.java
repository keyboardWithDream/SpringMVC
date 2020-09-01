package com.study.springmvc.controller;

import com.study.springmvc.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Harlan
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串
     * @param model 存对象
     * @return 跳转
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");

        //模拟从数据库查询出User对象
        User user = new User();
        user.setUsername("Harlan");
        user.setPassword("123456");
        user.setAge(23);

        //存入model对象
        model.addAttribute("user", user);

        return "success";
    }

    /**
     * 返回值为Void
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("testVoid方法执行了...");
        //请求转发
        req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req, resp);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
        //直接响应
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("test/html;charset=UTF-8");
        resp.getWriter().println("Hello,World!");
    }

    @RequestMapping("forwardOrRedirect")
    public String forwardOrRedirect(){
        System.out.println("forwardOrRedirect方法执行了...");
        return "forward:/WEB-INF/pages/success.jsp";
        //return "redirect:/index.jsp";
    }
}
