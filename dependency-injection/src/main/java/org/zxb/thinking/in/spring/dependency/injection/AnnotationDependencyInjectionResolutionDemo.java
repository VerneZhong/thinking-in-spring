package org.zxb.thinking.in.spring.dependency.injection;

import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 注解驱动的依赖注入处理过程，实现原理是 {@link DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter)} 方法解析注入的依赖
 *
 * @author Mr.zxb
 * @date 2020-07-11 17:40
 */
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    @Lazy
    private User userLazy; // 依赖查找（处理）+ 延迟

    @Autowired          // 依赖查找（处理）
    private User user;  // DependencyDescriptor
                        // 必须（required=true）
                        // 实时注入（eager=true）
                        // 通过类型（User.class）
                        // 字段名称（"user"）
                        // 是否首要（primary=true）

    @Autowired  // 集合类型注入
    private Map<String, User> users;  // user + superUser

    @Autowired
    private Optional<User> userOptional;  // superUser

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class(配置类) -> Spring Bean
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 Xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyInjectionResolutionDemo demo =
                applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        // 期待输出 superUser
        System.out.println("demo.user = " + demo.user);

        // 期待输出 user + superUser
        System.out.println("demo.users = " + demo.users);

        // 期待输出 user + superUser
        System.out.println("demo.userOptional = " + demo.userOptional);

        // 关闭 Spring 上下文
        applicationContext.close();
    }
}
