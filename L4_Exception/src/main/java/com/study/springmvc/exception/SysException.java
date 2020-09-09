package com.study.springmvc.exception;

/**
 * 自定义异常类
 * @Author Harlan
 * @Date 2020/9/8
 */
public class SysException extends Exception{

    /**
     * 提示信息
     */
    private String msg;

    public SysException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
