package org.zxb.thinking.in.spring.bean.lifecycle.domain;

import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * User Holder 类
 *
 * @author Mr.zxb
 * @date 2020-09-11 17:01
 */
public class UserHolder {
    private final User user;

    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
