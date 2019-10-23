package com.dao;
import java.util.*;
import  com.entity.*;
public interface IUserinfoDao {
    //新增
    Integer insert(Userinfo userinfo);
    //查询所有
    List<Userinfo> selectAlluserinfo() ;
    //按uid查找
    Userinfo selectByuid(Integer uid);

    //修改
    Integer updateByPrimaryKey(Userinfo userinfo);
}
