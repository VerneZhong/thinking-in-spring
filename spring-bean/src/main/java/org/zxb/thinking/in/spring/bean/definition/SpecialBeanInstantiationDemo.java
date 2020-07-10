package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zxb.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.zxb.thinking.in.spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊方式 {@link ServiceLoaderFactoryBean} 方式来 Bean 示例化示例
 *
 * @author Mr.zxb
 * @date 2020-03-03 10:33
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {

        // 配置 XML 配置，启动 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");

        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        // ServiceLoader 方式
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);

//        serviceLoaderTest();

        // 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    /**
     * ServiceLoader 加载实例
     */
    public static void serviceLoaderTest() {
        ServiceLoader<UserFactory> loader = ServiceLoader.load(UserFactory.class,
                Thread.currentThread().getContextClassLoader());
        displayServiceLoader(loader);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> loader) {
        Iterator<UserFactory> iterator = loader.iterator();
        while (iterator.hasNext()) {
            UserFactory factory = iterator.next();
            System.out.println(factory.createUser());
        }
    }
}
