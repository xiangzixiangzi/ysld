package com.action;
import  java.util.*;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.aliyuncs.exceptions.ClientException;
import  com.entity.*;
import  com.service.*;
import com.util.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpSession;


@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class UserCOntroller {

    @Value("${app.code}")
    private String code;

    @Autowired
    private IUserService us;
    @Autowired
    private SmsUtil smsUtil;
    @Autowired
    private IUserinfoService uf;
    @Autowired
    private IReceivingService re;
    String yzm;
    //注册
    @RequestMapping(value = "/zhuceuser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer zhuceuser(User u){
        System.out.println("----------------------进入注册");
        if (u.getYanzheng().equals(yzm)){
            int num1 =0;
            int num =us.insert(u);
            System.out.println("------------uid="+u.getUid());
            if (num>0){
                Userinfo userinfo =new Userinfo();
                         userinfo.setUid(u.getUid());
                         uf.insert(userinfo);//新增空的userinfo表
                return 1;
            }else {
                return num1;
            }
        }else {
            System.out.println("验证码错误！！！");
            return 0;
        }

    }
    /*@RequestMapping(value = "/adduser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer adduser(@RequestParam Map<String,Object> mp){
        System.out.println("----------------------进入新增"+mp);
        String uname =(String)mp.get("uname1");
        String telephone =(String)mp.get("telephone1");
        User user = new User();
             user.setUname(uname);
             user.setTelephone(telephone);
        int num =us.insert(user);
            *//*user.getUid();*//*

        if (num>0){
            Receiving receiving =new Receiving();
           *//* String uid=(String) mp.get("uid");
            Integer id=Integer.valueOf(uid);*//*  *//*取map中的uid*//*
            String  province=(String)mp.get("s_province");
            String  city=(String)mp.get("s_city");
            String  county=(String)mp.get("s_county");
            String  raddress=(String)mp.get("raddress");
            String dizhi = province+city+county+raddress;
            receiving.setUid(user.getUid());*//*上面新增的uid*//*
            receiving.setRaddress(dizhi);

            int num1 =re.insert(receiving);
            return 1;

        }else {
            return 0;
        }

    }*/
    @RequestMapping(value = "/alluser", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<User> alluser() {
        System.out.print("----------------");
        return us.selectAll();
    }
    //登录
    @RequestMapping(value = "/loginuser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer loginuser(User u, HttpSession session){
        System.out.println("----------------------进入登录");
        int num=0;
        User su=null;
        su=us.selectlogin(u);
        if (su!=null){
            num =1;


        }
        session.setAttribute("info",su);
        return  num;
    }
    //重设密码
    @RequestMapping(value = "/chongshe",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User chongshe(HttpSession session){

        User sub =(User)session.getAttribute("info");
        if(sub==null){
            sub = new User();
        }
        System.out.println("  sub ="+sub);
        return sub;
    }

    //修改
    @RequestMapping(value = "/updateuser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updateuser(User u,HttpSession session){

        System.out.println("------------进入到修改");
        //隐藏域有id，在通过id找到原来的数据，再取到原来的时间，传到新的对象b里面.加以前数据
        User uu=us.selectByPrimaryKey(u.getUid());
             uu.getDate();
             u.setDate(uu.getDate());
             uu.getTelephone();
             u.setTelephone(uu.getTelephone());
             uu.getLogintime();
             u.setLogintime(uu.getLogintime());
             uu.getJurisdiction();
             u.setJurisdiction(uu.getJurisdiction());

        System.out.println("------------u="+u);
        Integer num=us.updateByPrimaryKey(u);
        if (num>0){
            session.setAttribute("info",u);
        }
        return num;
    }
    //名字查询功能
    @RequestMapping(value = "/oneuname",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User oneuname(String uname){
        System.out.println("------------进入名字查询功能");
        User user = us.selectByuname(uname);
        if (user!=null){
            return user;
        }
        return new User();
    }
    //手机号查询功能
    @RequestMapping(value = "/onetelephone",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User onetelephonee(String telephone){
        System.out.println("------------进入手机查询功能");
        User user = us.selectBytelephone(telephone);
        if (user!=null){
            return user;
        }
        return new User();
    }
    //id查询功能
    @RequestMapping(value = "/oneuid/{uid}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User oneuid(@PathVariable(value = "uid") Integer uid){
        System.out.println("------------进入手机id查询功能");
        User user = us.selectByPrimaryKey(uid);
        if (user!=null){
            return user;
        }
        return new User();
    }
    @RequestMapping(value = "/sms/{telephone}")
    public String sms(@PathVariable(value = "telephone") String telephone) throws ClientException {
        System.out.println("------------进入短息功能");
        final String smscode = (long)(Math.random()*1000000)+"";
        /*定全局变量等于随机数*/
        yzm = smscode;
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("code",smscode);

        Map<String,String> map = new HashMap<String, String>();
        map.put("phone",telephone);//手机号
        map.put("sign_name","箱子");//签名名字
        map.put("template_code","SMS_174987702");//模板code
        map.put("sms_code", JSON.toJSONString(map1));//随机数

        smsUtil.sendSms(map.get("phone"),map.get("sign_name"),
                map.get("template_code"),map.get("sms_code"));


        return yzm;//返回string ，调用到前台的忘记密码
    }

}
