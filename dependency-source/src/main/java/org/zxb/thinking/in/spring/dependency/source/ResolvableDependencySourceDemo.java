package org.zxb.thinking.in.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 非 Spring 容器管理的 ResolvableDependency 作为依赖来源
 *
 * @author Mr.zxb
 * @date 2020-07-14 14:48
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器，并注册 DependencySourceDemo 配置类，并启动 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册 Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "Hello World");
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 显式关闭 Spring 上下文
        applicationContext.close();
    }
}
