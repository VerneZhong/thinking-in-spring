package org.zxb.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;
import org.zxb.thinking.in.spring.bean.lifecycle.domain.UserHolder;
import org.zxb.thinking.in.spring.ioc.overview.domain.SuperUser;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link Bean} 实例化生命周期示例
 *
 * @author Mr.zxb
 * @date 2020-09-11 15:21
 */
public class BeanInstantiationLifecycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加 BeanPostProcessor 实现（实例）
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency" +
                "-injection.xml"};
        // 基于 ClassPath 加载 XML 资源
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);

        // 通过 Bean ID 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        // 构造器注入按照类型注入, resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
                // 把配置完成 superUser Bean 覆盖
                return new SuperUser();
            }
            // 保持不变，使用默认，保持 Spring IoC 容器实例化操作
            return null;
        }

        /**
         * 初始化之后的处理
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                User user = (User) bean;
                user.setId(2L);
                user.setName("xixi");
                // "user" 对象不允许属性赋值（配置元信息 -> 属性值）
                return false;
            }
            return true;
        }
    }
}
