package com.alibaba.csp.sentinel.demo.annotation.nativeaspectj.pkga;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author shenbaoyong
 */
public class Person {

    @SentinelResource(value = "addPersonResource", fallback = "addPersonFallback")
    public void addPerson(){
        System.out.println("addPerson");
    }

    public void searchPerson(){
        System.out.println("searchPerson");
    }

    public void addPersonFallback(){
        System.out.println("addPersonFallback");
    }

}
