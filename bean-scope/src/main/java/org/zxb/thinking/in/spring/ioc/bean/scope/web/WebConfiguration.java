package org.zxb.thinking.in.spring.ioc.bean.scope.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
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
    @RequestScope
    public User user() {
        return User.createUser(1L);
    }
}
