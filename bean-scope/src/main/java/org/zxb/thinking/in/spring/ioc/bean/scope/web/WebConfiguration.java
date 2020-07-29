package org.zxb.thinking.in.spring.ioc.bean.scope.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-07-29 09:21
 */
@EnableWebMvc
@Configuration
public class WebConfiguration {

    @Bean
//    @RequestScope // 每次 Http 请求都是创建新对象
//    @SessionScope   // 和cookie绑定，相同cookie操作同一个对象，同步操作
    @ApplicationScope
    public User user() {
        return User.createUser(1L);
    }
}
