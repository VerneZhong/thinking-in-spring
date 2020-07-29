package org.zxb.thinking.in.spring.ioc.bean.scope.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zxb.thinking.in.spring.ioc.overview.domain.User;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-07-29 09:18
 */
@Controller
public class IndexController {

    @Autowired
    private User user;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", user);
        return "index";
    }
}
