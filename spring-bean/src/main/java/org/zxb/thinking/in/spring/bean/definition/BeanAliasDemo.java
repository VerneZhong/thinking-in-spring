package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * Bean 别名示例
 *
 * @author Mr.zxb
 * @date 2020-02-20 20:14
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");

        // 通过别名 zxb-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User zxbUser = beanFactory.getBean("zxb-user", User.class);

        System.out.println("zxb-user 是否与 user bean 相同：" + (user == zxbUser));
    }
}
