package com.qfedu.dao;

import com.qfedu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    public User login(String loginId);
}
