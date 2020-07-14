package org.zxb.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

/**
 * 基于 注解 资源的依赖 字段 注入示例
 *
 * @author Mr.zxb
 * @date 2020-07-11 14:15
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired
    private
//    static // @Autowired 会忽略静态字段
    UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class(配置类) -> Spring Bean
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 Xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyFieldInjectionDemo demo =
                applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

        // @Autowired 字段关联
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);

        // 通过 byType 方式实现 -> true
        System.out.println(userHolder == demo.userHolder2);

        // 关闭 Spring 上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        // 构造器方式注入
        return new UserHolder(user);
    }
}
