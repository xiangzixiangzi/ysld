package com.service.impl;
import com.dao.*;
import com.entity.Quser;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "quserService")
public class QuserService implements IQuserService{
    @Autowired
    IQuserDao dao;

    @Override
    public Integer insert(Quser quser) {
        return dao.insert(quser);
    }

    @Override
    public Quser selectByrid(Integer rid) {
        return dao.selectByrid(rid);
    }

    @Override
    public Integer deleteByrid(Integer rid) {
        return dao.deleteByrid(rid);
    }

    @Override
    public Quser selectByRid(Integer rid) {
        return dao.selectByRid(rid);
    }
}
