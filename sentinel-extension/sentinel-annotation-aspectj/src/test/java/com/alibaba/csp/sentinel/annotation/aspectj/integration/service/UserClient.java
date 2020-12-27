package com.alibaba.csp.sentinel.annotation.aspectj.integration.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author shenbaoyong
 */
@SentinelResource(defaultFallback = "globalDefaultFallback", fallbackClass = FooUtil.class)
public interface UserClient {

    @SentinelResource
    public String getUserName1(int i);

    @SentinelResource(fallback = "getUserNameFallBack")
    public String getUserName2(int i);

    public String getUserNameFallBack(int i);

}
