package com.service;
import com.entity.*;

import java.util.*;
public interface IReceivingService {
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
