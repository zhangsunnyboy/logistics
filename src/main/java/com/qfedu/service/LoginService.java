package com.qfedu.service;

import com.qfedu.entity.User;

public interface LoginService {
    public User login(String loginId, String password);
}
