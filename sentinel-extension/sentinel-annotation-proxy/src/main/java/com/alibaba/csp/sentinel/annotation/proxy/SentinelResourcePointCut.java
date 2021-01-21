package com.alibaba.csp.sentinel.annotation.proxy;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author shenbaoyong
 */
public class SentinelResourcePointCut extends StaticMethodMatcherPointcut {

    private SentinelResourceExtractor sentinelResourceExtractor;

    public SentinelResourcePointCut(final SentinelResourceExtractor sentinelResourceExtractor) {
        this.sentinelResourceExtractor = sentinelResourceExtractor;
        /*setClassFilter(new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return null != sentinelResourceExtractor.extractFromClass(clazz);
            }
        });*/
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return null != sentinelResourceExtractor.extractFromMethod(method, targetClass);
    }

}
