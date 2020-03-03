package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * Bean 示例化示例
 *
 * @author Mr.zxb
 * @date 2020-03-03 10:33
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        // 配置 XML 配置，启动 Spring 上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");

        // 通过 静态工厂方法 实例化 Bean
        User user = beanFactory.getBean("user-by-static", User.class);

        // 通过 Bean 工厂方法 实例化 Bean
        User userInstance = beanFactory.getBean("user-by-instance-method", User.class);

        // 通过 FactoryBean 实例化 Bean
        User userFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userInstance);
        System.out.println(userFactoryBean);

        // false
        System.out.println(user == userInstance);
        System.out.println(user == userFactoryBean);
    }
}
