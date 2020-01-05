package org.zxb.thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.zxb.thinking.in.spring.ioc.overview.annotaion.Super;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;
import org.zxb.thinking.in.spring.ioc.overview.repository.UserRepository;

import java.util.Map;

/**
 * Spring IoC 依赖注入示例 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:19
 * @since 1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());
        // false
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory<ApplicationContext> userObjectFactory = userRepository.getObjectFactory();
        System.out.println(userObjectFactory.getObject());
        // true
        System.out.println(userObjectFactory.getObject() == beanFactory);

        // 依赖查找 (错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);

    }

}
