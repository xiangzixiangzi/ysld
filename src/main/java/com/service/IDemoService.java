package com.service;

import com.entity.Demo;

import java.util.List;

public interface IDemoService {

    List<Demo> selectAll();

    Demo selectByPrimaryKey(Integer did);

    int insert(Demo d);

    int deleteByPrimaryKey(Integer did);

    int updateByPrimaryKey(Demo d);
}
