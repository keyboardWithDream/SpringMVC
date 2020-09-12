package com.study.springmvc.interceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * @Author Harlan
 * @Date 2020/9/12
 */
public class Interceptor1 implements HandlerInterceptor {

    /**
     * 预处理方法, controller的方法之前执行
     * @param request request 可进行请求转发
     * @param response response 可进行重定向
     * @param handler handler
     * @return true 放行, false 不放行.
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理方法执行了111...");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理方法, controller方法执行后, success.jsp执行前
     * @param request request
     * @param response response
     * @param handler handler
     * @param modelAndView mv
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理方法执行了111...");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * success.jsp页面执行后执行
     * @param request request
     * @param response response
     * @param handler handler
     * @param ex ex
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after方法执行了111...");
    }
}
