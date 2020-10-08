package com.qfedu.service.impl;

import com.qfedu.dao.LoginDao;
import com.qfedu.entity.User;
import com.qfedu.service.LoginService;
import com.qfedu.util.Enctype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/5 9:48
 * description:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User login(String loginId, String password) {
        User user = loginDao.login(loginId);
        if(user ==null){
            throw new RuntimeException("账户错误");
        }else if(!user.getPassword().equals(Enctype.MD5(password))){
            throw new RuntimeException("密码错误");
        }
        return user;
    }
}
