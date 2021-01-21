package com.alibaba.csp.sentinel.annotation.proxy;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author shenbaoyong
 */
public class SentinelResourceAdvice implements MethodInterceptor {

    private SentinelResourceExtractor sentinelResourceExtractor;

    public SentinelResourceAdvice(SentinelResourceExtractor sentinelResourceExtractor) {
        this.sentinelResourceExtractor = sentinelResourceExtractor;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Method method = methodInvocation.getMethod();

        SentinelResource annotation = sentinelResourceExtractor.extractFromMethod(method, methodInvocation.getThis().getClass());

        //todo
        return null;

    }

}
