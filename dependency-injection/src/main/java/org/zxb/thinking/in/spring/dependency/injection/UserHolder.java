package org.zxb.thinking.in.spring.dependency.injection;

import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} 的 Holder 类
 *
 * @author Mr.zxb
 * @date 2020-07-11 14:10
 */
public class UserHolder {

    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
