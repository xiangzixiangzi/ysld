package com.dao;
import java.util.*;
import  com.entity.*;
public interface IUserDao {
    List<User> selectAll();
    //注册
    Integer insert(User u);
    //登录
    User selectlogin(User u);
    //修改
    Integer updateByPrimaryKey(User u);
    //按名字，号码，ID查找全部
    User selectByuname(String uname);
    User selectBytelephone(String telephone);
    User selectByPrimaryKey(Integer uid);
}
