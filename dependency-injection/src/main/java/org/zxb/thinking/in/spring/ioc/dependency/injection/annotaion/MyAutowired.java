package org.zxb.thinking.in.spring.ioc.dependency.injection.annotaion;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * 自定义注入注解，扩展于 {@link Autowired}
 *
 * @author Mr.zxb
 * @date 2020-07-13 15:53
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutowired {
    boolean required() default true;
}
