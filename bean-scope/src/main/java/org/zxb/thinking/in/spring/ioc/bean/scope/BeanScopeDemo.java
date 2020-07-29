package org.zxb.thinking.in.spring.ioc.bean.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Bean 的作用域示例
 *
 * @author Mr.zxb
 * @date 2020-07-14 16:36
 */
public class BeanScopeDemo implements DisposableBean {

    @Bean
    // 默认 Scope 就是 "singleton"
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> userMap;

    @Autowired
    private List<User> userList;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory; // Resolvable Dependency

    public static void main(String[] args) {
        // 创建 BeanFactory 容器，并注册 BeanScopeDemo 配置类，并启动 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(BeanScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称：%s 在初始化后回调... %n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 结论一：
        // Singleton Bean 无论是依赖查找还是依赖注入，均为同一个对象
        // Prototype Bean 无论是依赖查找还是依赖注入，均为新生成的对象

        // 结论二：
        // 如果依赖注入集合类型的对象，Singleton Bean 和 Prototype Bean 均会存在一个
        // Prototype Bean 有别于其他地方的依赖注入 Prototype Bean

        // 结论三：
        // 无论是 Singleton 还是 Prototype Bean 均会执行初始化方法回调
        // 不过仅 Singleton Bean 会执行销毁方法回调
        scopedBeanByLookup(applicationContext);
        scopedBeanByInjection(applicationContext);

        // 显式关闭 Spring 上下文
        applicationContext.close();
    }

    private static void scopedBeanByInjection(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo demo = applicationContext.getBean(BeanScopeDemo.class);

        System.out.println("demo.singletonUser = " + demo.singletonUser);
        System.out.println("demo.singletonUser1 = " + demo.singletonUser1);

        System.out.println("demo.prototypeUser = " + demo.prototypeUser);
        System.out.println("demo.prototypeUser1 = " + demo.prototypeUser1);
        System.out.println("demo.prototypeUser2 = " + demo.prototypeUser2);

        System.out.println("demo.userMap = " + demo.userMap);

        System.out.println("demo.userList = " + demo.userList);

    }

    private static void scopedBeanByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            // singletonUser 是共享 Bean 对象
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            System.out.println("singletonUser = " + singletonUser);

            // prototypeUser 是每次依赖查找均生成新的 Bean 对象
            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }


    @Override
    public void destroy() throws Exception {

        System.out.println("当前 BeanScopeDemo Bean 正在销毁中...");
        
        this.prototypeUser.destroy();
        this.prototypeUser1.destroy();
        this.prototypeUser2.destroy();
        // 获取 BeanDefninition
       for ( Map.Entry<String, User> entry : userMap.entrySet()) {
           String beanName = entry.getKey();
           BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
           // 如果当前 Bean 是 Prototype scope
           if (beanDefinition.isPrototype()) {
               entry.getValue().destroy();
           }
       }

        for (User user : userList) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(user.getBeanName());
            if (beanDefinition.isPrototype()) {
                user.destroy();
            }
        }

        System.out.println("当前 BeanScopeDemo Bean 销毁结束...");
    }
}
