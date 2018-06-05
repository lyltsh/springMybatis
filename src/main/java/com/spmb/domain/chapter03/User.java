package com.spmb.domain.chapter03;

import java.io.Serializable;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/5
 */
public class User implements Serializable {

    // 私有字段
    private String loginname;
    private String password;
    private String username;

    // 公共构造器
    public User() {
        super();
    }

    public User(String loginname, String password, String username) {
        super();
        this.loginname = loginname;
        this.password = password;
        this.username = username;
    }


    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [loginname=" + loginname + ", password=" + password
                + ", username=" + username + "]";
    }

}
