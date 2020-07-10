package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zxb.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.zxb.thinking.in.spring.bean.factory.UserFactory;

/**
 * 单体 Bean 注册实例
 *
 * @author Mr.zxb
 * @date 2020-03-04 15:40
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 创建一个 UserFactory 外部对象
        UserFactory userFactory = new DefaultUserFactory();
        SingletonBeanRegistry beanFactory = applicationContext.getBeanFactory();

        // 注册外部单体对象
        beanFactory.registerSingleton("userFactory", userFactory);

        // 启动 Spring 上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 UserFactory
        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryByLookup : " + (userFactory == userFactoryByLookup));

        // 关闭 Spring 上下文
        applicationContext.close();
    }
}
