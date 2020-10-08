package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.util.JsonResult;
import com.qfedu.service.LoginService;
import com.qfedu.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/5 11:04
 * description:
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login.do")
    public JsonResult login(String loginId, String password){
        User user = loginService.login(loginId, password);
        return new JsonResult(1,user);
    }
    @RequestMapping("/logout.do")
    public JsonResult logout(HttpSession session){
        session.invalidate();
        return new JsonResult(1,"退出成功");
    }

}
