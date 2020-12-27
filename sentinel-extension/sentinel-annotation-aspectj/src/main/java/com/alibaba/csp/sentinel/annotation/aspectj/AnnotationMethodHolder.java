package com.alibaba.csp.sentinel.annotation.aspectj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author shenbaoyong
 */
public class AnnotationMethodHolder<A extends Annotation> {

    private A sentinelResource;

    private Method method;

    public AnnotationMethodHolder(A sentinelResource, Method method) {
        this.sentinelResource = sentinelResource;
        this.method = method;
    }

    public A getSentinelResource() {
        return sentinelResource;
    }

    public Method getMethod() {
        return method;
    }
}
