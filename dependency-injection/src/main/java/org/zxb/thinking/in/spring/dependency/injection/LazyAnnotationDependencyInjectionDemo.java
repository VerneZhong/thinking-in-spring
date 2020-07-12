package org.zxb.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Set;

/**
 * {@link ObjectProvider} 实现延迟依赖注入
 *
 * @author Mr.zxb
 * @date 2020-07-11 17:40
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; // 实时注入  ->  superUser

    @Autowired
    private ObjectProvider<User> userObjectProvider; // 延迟注入  -> superUser

    @Autowired
    private ObjectFactory<Set<User>> userObjectFactory;  // user + superUser

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class(配置类) -> Spring Bean
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 Xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        LazyAnnotationDependencyInjectionDemo demo =
                applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

        // 期待输出 superUser
        System.out.println("demo.user = " + demo.user);
        // 继承 ObjectFactory
        System.out.println("demo.userObjectProvider = " + demo.userObjectProvider.getObject());
        System.out.println("demo.userObjectFactory = " + demo.userObjectFactory.getObject());

        // 输出 user + superUser
        demo.userObjectProvider.forEach(System.out::println);

        // 关闭 Spring 上下文
        applicationContext.close();
    }
}
