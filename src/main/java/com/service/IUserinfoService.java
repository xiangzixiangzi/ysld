package com.service;
import com.entity.*;

import java.util.*;
public interface IUserinfoService {
    //新增
    Integer insert(Userinfo userinfo);
    //查询所有
    List<Userinfo> selectAlluserinfo() ;
    //按uid查找
    Userinfo selectByuid(Integer uid);

    //修改
    Integer updateByPrimaryKey(Userinfo userinfo);
}
