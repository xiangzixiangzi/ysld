package com.service.impl;
import com.dao.*;
import com.entity.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "receivingService")
public class ReceivingService implements IReceivingService{
    @Autowired
    IReceivingDao dao;

    @Override
    public Integer insert(Receiving r) {
        return dao.insert(r);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer rid) {
        return dao.deleteByPrimaryKey(rid);
    }

    @Override
    public Integer updateByPrimaryKey(Receiving receiving) {
        return dao.updateByPrimaryKey(receiving);
    }

    @Override
    public Receiving selectByPrimaryKey(Integer rid) {
        return dao.selectByPrimaryKey(rid);
    }

    @Override
    public List<Receiving> selectByuid(Integer uid) {
        return dao.selectByuid(uid);
    }
}
