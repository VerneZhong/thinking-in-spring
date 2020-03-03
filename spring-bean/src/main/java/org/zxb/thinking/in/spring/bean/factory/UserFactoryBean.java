package org.zxb.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} Bean 的 {@link FactoryBean} 实现
 *
 * @author Mr.zxb
 * @date 2020-03-03 11:06
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
