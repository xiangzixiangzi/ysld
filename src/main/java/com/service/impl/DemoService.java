package com.service.impl;

import com.dao.IDemoDao;
import com.entity.Demo;
import com.service.IDemoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "demoService")
public class DemoService implements IDemoService {

    @Autowired
    IDemoDao d;

    @Override
    public List<Demo> selectAll() {
        return d.selectAll();
    }

    @Override
    public Demo selectByPrimaryKey(Integer did) {
        return d.selectByPrimaryKey(did);
    }

    @Override
    public int insert(Demo de) {
        return d.insert(de);
    }

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return d.deleteByPrimaryKey(did);
    }

    @Override
    public int updateByPrimaryKey(Demo de) {
        return d.updateByPrimaryKey(de);
    }
}
