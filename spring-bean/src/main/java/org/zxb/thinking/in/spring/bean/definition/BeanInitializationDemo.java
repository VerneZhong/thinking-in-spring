package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        // 关闭 Spring 上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}
