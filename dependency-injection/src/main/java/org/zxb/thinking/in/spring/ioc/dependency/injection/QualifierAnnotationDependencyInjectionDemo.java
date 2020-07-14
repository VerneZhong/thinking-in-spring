package org.zxb.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.zxb.thinking.in.spring.ioc.dependency.injection.annotaion.UserGroup;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * {@link Qualifier} 注解依赖注入
 *
 * @author Mr.zxb
 * @date 2020-07-11 17:40
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; // primary -> superUser

    @Autowired
    @Qualifier("user") // 指定 Bean 名称或 ID
    private User nameUser;

    @Bean
    @Qualifier // 进行逻辑分组
    public User user1() {
        return User.createUser(7L);
    }

    // 整体应用上下文存在4个 User 类型的 Bean
    // superUser
    // user
    // user1 @Qualifier
    // user2 @Qualifier

    @Autowired
    private Collection<User> allUsers; // 2 Beans = user + superUser

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers; // 2 Beans = user1 + user2 -> 4 Beans = user1 + user2 + user3 + user4

    @Bean
    @Qualifier
    public User user2() {
        return User.createUser(8L);
    }

    @Autowired
    @UserGroup
    private Collection<User> groupUsers; // 2 user3 + user4

    @Bean
    @UserGroup
    public User user3() {
        return User.createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4() {
        return User.createUser(10L);
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class(配置类) -> Spring Bean
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 Xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        QualifierAnnotationDependencyInjectionDemo demo =
                applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        // 期待输出 superUser
        System.out.println("demo.user = " + demo.user);
        // 期待输出 user
        System.out.println("demo.nameUser = " + demo.nameUser);

        // 期待输出 user1 user2
        System.out.println("demo.allUsers = " + demo.allUsers);

        // 期待输出 user1 user2
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);

        // 期待输出 user3 user4
        System.out.println("demo.groupUsers = " + demo.groupUsers);

        // 关闭 Spring 上下文
        applicationContext.close();
    }
}
