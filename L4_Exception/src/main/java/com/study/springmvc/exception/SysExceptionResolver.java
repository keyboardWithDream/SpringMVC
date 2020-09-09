package com.study.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * @Author Harlan
 * @Date 2020/9/8
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常逻辑
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 当前处理器对象
     * @param ex 异常对象
     * @return 返回页面
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SysException e = null;
        if (ex instanceof SysException){
            e = (SysException)ex;
        }else {
            e = new SysException("服务器正忙...");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("exceptionMsg", e.getMsg());
        mv.setViewName("error");
        return mv;
    }
}
