package com.action;
import com.dao.*;
import  com.entity.*;
import  com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class QuserController {
    @Value("${app.code}")
    private String code;
    @Autowired
    private IQuserService qu;

    @Autowired
    private IReceivingService re;

    //按RID查找
    @RequestMapping(value ="/quserrid/{rid}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Quser onebill(@PathVariable(value = "rid") Integer rid)throws Exception{
        System.out.println("----------------进入按rid查询");
        Quser sb = qu.selectByrid(rid);

        return  sb;
    }

    //删除
    @RequestMapping(value = "/delquser/{rid}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delquser(@PathVariable(value = "rid") Integer rid)throws  Exception{

        return 1;
    }

}
