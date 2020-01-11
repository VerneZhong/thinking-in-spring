package org.zxb.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * Xml 配置能力 {@link BeanFactory} Spring IoC 容器 class
 *
 * @author Mr.zxb
 * @date 2020-01-11 15:52
 */
public class IocContainerDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建 Xml 配置读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // Xml 配置文件 ClassPath 路径
        String location = "classpath:META-INF/dependency-lookup-context.xml";

        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);

        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有到User 集合对象：" + beans);
        }
    }
}
