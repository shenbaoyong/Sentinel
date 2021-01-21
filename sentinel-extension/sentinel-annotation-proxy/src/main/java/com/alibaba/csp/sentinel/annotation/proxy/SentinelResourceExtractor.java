package com.alibaba.csp.sentinel.annotation.proxy;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

import java.lang.reflect.Method;

/**
 * @author shenbaoyong
 */
public interface SentinelResourceExtractor {

    SentinelResource extractFromClass(Class clazz);

    SentinelResource extractFromMethod(Method method, Class clazz);


}
