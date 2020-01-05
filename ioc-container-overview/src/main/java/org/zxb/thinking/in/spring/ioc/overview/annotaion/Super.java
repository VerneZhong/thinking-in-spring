package org.zxb.thinking.in.spring.ioc.overview.annotaion;


import java.lang.annotation.*;

/**
 * 超级 annotation
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
