package org.zxb.thinking.in.spring.ioc.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * 用户信息仓库 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 17:20
 */
public class UserRepository {

    /**
     * 自定义 Bean
     */
    private Collection<User> users;

    /**
     * 内建非 Bean 对象（依赖）
     */
    private BeanFactory beanFactory;

    /**
     * 内建Bean 对象
     */
    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
