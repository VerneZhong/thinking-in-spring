package org.zxb.thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.zxb.thinking.in.spring.ioc.overview.repository.UserRepository;

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
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext
//        ("classpath:META-INF/dependency-injection-context.xml");

        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext
                .getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        whoIsIocContainer(userRepository, applicationContext);

        // 依赖来源二：依赖注入（内建依赖）-> DefaultListableBeanFactory
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory<ApplicationContext> userObjectFactory = userRepository.getObjectFactory();
        // ApplicationContext
        System.out.println(userObjectFactory.getObject());
        // true
        System.out.println("内建 Bean 对象：" + (userObjectFactory.getObject() == applicationContext));

        // 依赖查找 (错误)
//        System.out.println(applicationContext
//        .getBean(BeanFactory.class));

        // 依赖来源三：容器内建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);

    }

    private static void whoIsIocContainer(UserRepository userRepository,
                                          ApplicationContext applicationContext) {

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()

        // 这个表达式为什么会不成立
        // 因为 AbstractRefreshableApplicationContext创建了DefaultListableBeanFactory，他们俩个并不是一个对象
        // false
        System.out.println("内建非 Bean 对象（依赖）: " + (userRepository.getBeanFactory() == applicationContext));

        // ApplicationContext is BeanFactory

    }

}
