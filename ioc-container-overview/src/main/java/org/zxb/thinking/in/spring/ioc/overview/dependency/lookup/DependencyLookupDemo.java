package org.zxb.thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zxb.thinking.in.spring.ioc.overview.annotaion.Super;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * Spring IoC 依赖查找示例 class
 * 1. 通过名称的方式来查找
 * 2. 通过类型的方式来查找
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:19
 * @since 1.0
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-lookup-context.xml");
        // 按名称查找
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);

        // 按类型查找
        lookupByType(beanFactory);

        // 按名称+类型方式查找
//        lookupByNameAndType(beanFactory);

        // 按类型查找集合对象
        lookupCollectionByType(beanFactory);

        // 按注解方式查找
        lookupByAnnotation(beanFactory);
    }

    /**
     * 按注解方式查找集合对象
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            // Map Key -> user Bean id, Value = User 对象
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("按注解查找 User 集合对象：" + users);
        }
    }

    /**
     * 根据 Bean 类型查找集合对象
     * @param beanFactory
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            // Map Key -> user Bean id, Value = User 对象
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按类型查找 User 集合对象：" + users);
        }
    }

    /**
     * 通过 Bean 类型查找
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型实时查找：" + user);
    }

    /**
     * 通过 Bean 名称 + 类型查找
     * @param beanFactory
     */
    private static void lookupByNameAndType(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user2", User.class);
        System.out.println("按类型+名称实时查找：" + user);
    }

    /**
     * Bean 名称延迟查找
     *
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        // FactoryBean 结果就不一样了
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    /**
     * Bean 名称实时查找
     *
     * @param beanFactory
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }
}
