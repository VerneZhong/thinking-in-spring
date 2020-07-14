package org.zxb.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源示例
 *
 * @author Mr.zxb
 * @date 2020-07-14 10:33
 */
public class DependencySourceDemo {

    // 注入在 postProcessProperties 方法执行，早于 Setter 注入，也早于 @PostConstruct
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void initByInjection() {
        System.out.println("beanFactory == applicationContext " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext " + (resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext " + (applicationEventPublisher == applicationContext));
    }

    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    public <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("当前类型" + beanType.getName() + " 无法在 BeanFactory 中查找！");
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器，并注册 DependencySourceDemo 配置类，并启动 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencySourceDemo.class);

        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);

        // 显式关闭 Spring 上下文
        applicationContext.close();
    }
}
