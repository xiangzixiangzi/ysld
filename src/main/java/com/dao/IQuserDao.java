package com.dao;
import java.util.*;
import com.entity.*;

public interface IQuserDao {
    //新增
    Integer insert(Quser quser);
    //按ID查找
    Quser selectByrid(Integer rid);
    //删除
    Integer deleteByrid(Integer rid);

    Quser selectByRid(Integer rid);
}
