package com.service.impl;

import com.service.IUserinfoService;
import com.dao.*;
import com.entity.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "userInfoService")
public class UserInfoService implements IUserinfoService{

    @Autowired
    IUserinfoDao dao;

    @Override
    public Integer insert(Userinfo userinfo) {
        return dao.insert(userinfo);
    }

    @Override
    public List<Userinfo> selectAlluserinfo() {
        return dao.selectAlluserinfo();
    }

    @Override
    public Userinfo selectByuid(Integer uid) {
        return dao.selectByuid(uid);
    }

    @Override
    public Integer updateByPrimaryKey(Userinfo userinfo) {
        return dao.updateByPrimaryKey(userinfo);
    }


}
