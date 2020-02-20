package org.zxb.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext } 作为 Spring IoC 容器 class
 *
 * @author Mr.zxb
 * @date 2020-01-11 15:52
 */
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        // 创建 Spring上下文 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类 (Configuration Class)
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

        // 初始化上下文
        applicationContext.refresh();

        // 按照类型查找
        lookupCollectionByType(applicationContext);

        // 关闭上下文
        applicationContext.close();
    }

    /**
     * Bean 定义
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(3L);
        user.setName("川普");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有到User 集合对象：" + beans);
        }
    }
}
