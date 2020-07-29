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
    private User user;  // CGLIB 代理后的对象（不变的）

    @GetMapping
    public String index(Model model) {
//     JSP EL 变量搜索路径：   page -> request -> session -> application(ServletContext)
        // userObject -> 渲染上下文
        // user 对象存在 ServletContext 上下文名称：scopedTarget.user == 新生成 Bean 名称
        model.addAttribute("userObject", user);
        return "index";
    }
}
