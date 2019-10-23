package com.dao;
import java.util.*;
import  com.entity.*;
public interface IReceivingDao {
    //新增
    Integer insert(Receiving r);
    //删除
    Integer deleteByPrimaryKey(Integer rid);
    //修改
    Integer updateByPrimaryKey(Receiving receiving);
    //按id差
    Receiving selectByPrimaryKey(Integer rid);

    //按uid查
    List<Receiving> selectByuid(Integer uid);
}
