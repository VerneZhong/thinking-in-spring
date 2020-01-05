package com.zxb.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 *
 * @author Mr.zxb
 * @date 2020-01-04 17:01
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
            // GUI -> text(String) -> PropertyType
            // name -> String
            // age -> Integer
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            // 为 "age" 字段/属性增加 PropertyEditor
            if ("age".equals(propertyName)) {
                 // String -> Integer
//                Integer.valueOf("")
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                propertyDescriptor.createPropertyEditor();
            }

            System.out.println(propertyType);
        });

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
