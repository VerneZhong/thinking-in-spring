package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * 注解 {@link BeanDefinition} 示例
 *
 * @author Mr.zxb
 * @date 2020-02-20 20:24
 */
// 3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1. 命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext, "chivalry-user");
        // 2. 非命名 Bean 的注册方法
        registerBeanDefinition(applicationContext);

        // 启动上下文
        applicationContext.refresh();

        // 1. 通过 @Bean 方式定义
        // 2. 通过 @Component 方式
        // 3. 通过 @Import 来进行导入

        // 按照类型依赖查找
        System.out.println("Config 的所有 Beans: " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 的所有 Beans: " + applicationContext.getBeansOfType(User.class));

        // 显示关闭 Spring 应用上下午
        applicationContext.close();
    }

    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 2L)
        .addPropertyValue("name", "钟学斌");

        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean 组件
    public static class Config {

        // 1. 通过 @Bean 方式定义
        /**
         * 通过 Java 注解的方式，定义一个 Bean
         * @return
         */
        @Bean(name = {"user", "zxb-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("钟学斌");
            return user;
        }

    }
}
