package org.zxb.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 默认 {@link UserFactory} 实现
 *
 * @author Mr.zxb
 * @date 2020-03-03 11:00
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {

    /**
     * 1. 基于 @PostConstruct 注解
     */
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

    /**
     * 2. 实现 {@link InitializingBean#afterPropertiesSet()} 接口的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet : UserFactory 初始化中...");
    }

    /**
     * 3. 自定义初始化方法
     */
    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory : UserFactory 初始化中...");
    }

}
