package org.zxb.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于 Xml 资源的依赖 Setter 方法注入示例
 *
 * @author Mr.zxb
 * @date 2020-07-11 13:54
 */
public class XmlDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
        // 加载 Xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 依赖查找并且创建 Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println(userHolder);
    }
}
