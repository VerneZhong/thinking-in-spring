package org.zxb.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认 {@link UserFactory} 实现
 *
 * @author Mr.zxb
 * @date 2020-03-03 11:00
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

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

    @PreDestroy
    public void preDestroy() {
        System.out.println("@ProDestroy : UserFactory 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy() : UserFactory 销毁中...");
    }

    public void doDestroy() {
        System.out.println("自定义销毁方法 doDestroy : UserFactory 销毁中...");
    }
}
