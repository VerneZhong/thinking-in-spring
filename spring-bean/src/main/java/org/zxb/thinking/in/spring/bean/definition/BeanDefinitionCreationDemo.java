package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link BeanDefinition} Bean 元信息 示例 class
 *
 * @author Mr.zxb
 * @date 2020-01-11 18:26
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id", 4)
                .addPropertyValue("name", "钟学斌");

        // 获取 BeanDefinition 实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // BeanDefinition 并非 Bean 终态，可以自定义修改


        // 2.通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);

        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", "5");
//        propertyValues.addPropertyValue("name", "Zxb");
        // 等价于上面
        propertyValues.add("id", "5")
                .add("name", "Zxb");

        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
