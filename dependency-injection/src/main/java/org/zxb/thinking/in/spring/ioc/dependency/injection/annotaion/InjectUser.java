package org.zxb.thinking.in.spring.ioc.dependency.injection.annotaion;

import java.lang.annotation.*;

/**
 * 自定义依赖注入注解
 *
 * @author Mr.zxb
 * @date 2020-07-13 15:56
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectUser {
}
