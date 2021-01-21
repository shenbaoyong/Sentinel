package com.alibaba.csp.sentinel.annotation.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;

/**
 * @author shenbaoyong
 */
public class SentinelResourceAdvisor extends AbstractPointcutAdvisor {

    private SentinelResourceExtractor sentinelResourceExtractor;

    private Pointcut pointcut;

    private Advice advice;

    public SentinelResourceAdvisor(boolean checkInherited) {
        sentinelResourceExtractor = new DefaultSentinelResourceExtractor(checkInherited);
        pointcut = new SentinelResourcePointCut(sentinelResourceExtractor);
        advice = new SentinelResourceAdvice(sentinelResourceExtractor);
    }

    public SentinelResourceAdvisor() {
        this(true);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
