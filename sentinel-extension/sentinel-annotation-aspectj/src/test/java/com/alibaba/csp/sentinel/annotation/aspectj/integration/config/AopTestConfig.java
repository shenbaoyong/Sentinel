/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.annotation.aspectj.integration.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.annotation.aspectj.integration.service.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Eric Zhao
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.alibaba.csp.sentinel.annotation.aspectj.integration")
public class AopTestConfig {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @Bean
    public UserClient userClient(){

        return (UserClient) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{UserClient.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(args != null && args.length == 1 && (int)args[0] == 5758 && !method.getName().equals("getUserNameFallBack")){
                    throw new IllegalArgumentException("oops");
                }

                return method.getName() + "_" + (args != null && args.length == 1 ? args[0] : "");
            }
        });

    }
}
