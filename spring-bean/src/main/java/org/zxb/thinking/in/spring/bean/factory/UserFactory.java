package org.zxb.thinking.in.spring.bean.factory;

import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} 工厂类
 *
 * @author Mr.zxb
 * @date 2020-03-03 10:44
 */
public interface UserFactory {

    /**
     * 默认创建User方法
     * @return
     */
    default User createUser() {
        return User.createUser();
    }

}
