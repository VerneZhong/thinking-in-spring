package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.zxb.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.zxb.thinking.in.spring.bean.factory.UserFactory;

/**
 * Bean 初始化 示例
 *
 * @author Mr.zxb
 * @date 2020-03-04 10:23
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 上下文
        applicationContext.refresh();

        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动。。。。 ");

        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        System.out.println(userFactory);

        // 关闭 Spring 上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    // 延迟初始化开启后，就会按需加载，会在Spring 上下文启动之后加载
    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}
