package com.huwa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;   //id
    private String uname; //姓名
    private String pwd;   //密码
    private Integer sex;   //性别
    private Date birthday;  //时间
    private String idcard;  //身份证
    private String email;   //邮箱
    private String mobile;   //手机
    private String address;  //地址
    private Integer utype;   //类型

    public User() {
    }

    public User(String uname, String pwd, Integer sex, Date birthday, String idcard, String email, String mobile, String address) {
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
        this.idcard = idcard;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
}
