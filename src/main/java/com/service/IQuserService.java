package com.service;
import java.util.*;
import com.entity.*;
public interface IQuserService {
    //新增
    Integer insert(Quser quser);
    //按RID查找
    Quser selectByrid(Integer rid);
    //删除
    Integer deleteByrid(Integer rid);

    Quser selectByRid(Integer rid);
}
