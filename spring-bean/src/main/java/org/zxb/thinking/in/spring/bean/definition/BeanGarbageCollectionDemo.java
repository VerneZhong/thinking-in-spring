package org.zxb.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收（GC）示例
 *
 * @author Mr.zxb
 * @date 2020-03-04 15:27
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 上下文
        applicationContext.refresh();

        // 关闭 Spring 上下文
        applicationContext.close();

        // 触发 GC
        System.gc();
    }
}
