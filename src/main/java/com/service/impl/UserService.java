package com.service.impl;
import com.dao.IUserDao;
import com.entity.*;
import com.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "userService")
public class UserService implements IUserService{
    @Autowired
    IUserDao dao;

    @Override
    public List<User> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Integer insert(User u) {
        return dao.insert(u);
    }

    @Override
    public User selectlogin(User u) {
        return dao.selectlogin(u);
    }

    @Override
    public Integer updateByPrimaryKey(User u) {
        return dao.updateByPrimaryKey(u);
    }

    @Override
    public User selectByuname(String uname) {
        return dao.selectByuname(uname);
    }

    @Override
    public User selectBytelephone(String telephone) {
        return dao.selectBytelephone(telephone);
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return dao.selectByPrimaryKey(uid);
    }
}
