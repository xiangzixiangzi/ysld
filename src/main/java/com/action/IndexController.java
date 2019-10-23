package com.action;


import  java.util.*;
import  com.entity.*;
import  com.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class IndexController {

    @Value("${app.code}")
    private String code;


    @Autowired
    private IDemoService ds;
    @Autowired
    private IUserService us;
    @RequestMapping(value = "/alldemo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Demo> alldemo() {
        System.out.print("----------------");
        return ds.selectAll();
    }


    @RequestMapping(value = "/onedemo/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Demo onedemo(@PathVariable(value = "id") Integer did) {

        return ds.selectByPrimaryKey(did);
    }

    @RequestMapping(value = "/deldemo/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer deldemo(@PathVariable(value = "id") Integer did) {

        return ds.deleteByPrimaryKey(did);
    }

    @RequestMapping(value = "/updemo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updemo(Demo d) {

        return ds.updateByPrimaryKey(d);
    }

    @RequestMapping(value = "/adddemo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer adddemo(Demo d) {
        System.out.print("---------------" + d);
        Integer num = ds.insert(d);
        System.out.print("---------------" + num);
        return num;
    }
}
