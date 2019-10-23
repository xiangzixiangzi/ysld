package com.dao;

import java.util.List;
import  com.entity.*;
public interface IDemoDao {

   List<Demo> selectAll();

   Demo selectByPrimaryKey(Integer did);

   int insert(Demo d);

   int deleteByPrimaryKey(Integer did);

    int updateByPrimaryKey(Demo d);
}
