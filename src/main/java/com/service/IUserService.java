package com.service;
import com.entity.*;

import java.util.*;
public interface IUserService {
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
