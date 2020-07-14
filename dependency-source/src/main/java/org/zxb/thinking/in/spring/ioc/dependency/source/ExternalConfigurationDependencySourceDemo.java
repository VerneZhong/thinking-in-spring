package org.zxb.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置作为依赖来源
 *
 * @author Mr.zxb
 * @date 2020-07-14 15:10
 */
@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties", encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${usr.name}")
    private String name;

    @Value("${user.resource:classpath://default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        // 创建 BeanFactory 容器，并注册 DependencySourceDemo 配置类，并启动 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        ExternalConfigurationDependencySourceDemo demo =
                applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println("demo.id = " + demo.id);
        System.out.println("demo.name = " + demo.name);
        System.out.println("demo.resource = " + demo.resource);

        // 显式关闭 Spring 上下文
        applicationContext.close();
    }
}
