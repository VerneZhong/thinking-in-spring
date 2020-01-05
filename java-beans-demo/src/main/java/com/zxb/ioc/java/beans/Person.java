package com.zxb.ioc.java.beans;

/**
 * 描述人的POJO类
 *
 * POJO 认为是： Setter/Getter 方法
 * Java Beans 认为是：可写方法（Writable）/可读方法（Readable）
 *
 * @author Mr.zxb
 * @date 2020-01-04 16:54
 */
public class Person {

    // String to String
    private String name;
    // String to Integer  涉及类型转换
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
