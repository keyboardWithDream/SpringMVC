package com.study.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Harlan
 * @date 2020-8-23 下午 7:59
 */
public class User implements Serializable {

    private String uname;
    private Integer age;
    private Date date;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
