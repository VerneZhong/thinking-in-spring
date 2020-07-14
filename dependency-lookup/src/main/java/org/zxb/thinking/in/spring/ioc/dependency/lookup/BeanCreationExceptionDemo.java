package org.zxb.thinking.in.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link BeanCreationException} 示例
 *
 * @author Mr.zxb
 * @date 2020-07-10 15:21
 */
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 BeanDefinition POJO Class 是一个 普通类，不过初始化方法回调时抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

        // 启动上下文
        applicationContext.refresh();

        // 关闭上下文
        applicationContext.close();
    }

    static class POJO implements InitializingBean {

        // CommonAnnotationBeanPostProcessor
        @PostConstruct
        public void init() throws Throwable {
            throw new Exception("init() : For purposes...");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet() : For purposes...");
        }
    }
}
