package com.alibaba.csp.sentinel.demo.annotation.nativeaspectj.pkgb;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author shenbaoyong
 */
public class User {

    @SentinelResource(value = "addUserResource", fallback = "addUserFallback")
    public void addUser(){
        System.out.println("addUser");
    }

    public void searchUser(){
        System.out.println("searchUser");
    }

    public void addUserFallback(){
        System.out.println("addUserFallback");
    }

}
