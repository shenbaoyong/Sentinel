package com.alibaba.csp.sentinel.annotation.proxy;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;

/**
 * @author shenbaoyong
 */
public class DefaultSentinelResourceExtractor implements SentinelResourceExtractor {

    private boolean checkInherited;

    public DefaultSentinelResourceExtractor(boolean checkInherited) {
        this.checkInherited = checkInherited;
    }

    @Override
    public SentinelResource extractFromClass(Class clazz) {
        return (this.checkInherited ? AnnotatedElementUtils.findMergedAnnotation(clazz, SentinelResource.class) :
                AnnotatedElementUtils.getMergedAnnotation(clazz, SentinelResource.class));
    }

    @Override
    public SentinelResource extractFromMethod(Method method, Class clazz) {
        Method specificMethod = AopUtils.getMostSpecificMethod(method, clazz);
        SentinelResource s = doExtractFromMethod(specificMethod);
        return s;
    }

    private SentinelResource doExtractFromMethod(Method method) {
        return (this.checkInherited ? AnnotatedElementUtils.findMergedAnnotation(method, SentinelResource.class) :
                AnnotatedElementUtils.getMergedAnnotation(method, SentinelResource.class));
    }
}
