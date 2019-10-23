package com.action;
import com.dao.IUserinfoDao;
import  com.entity.*;
import  com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.*;

@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class UserInfoController {
    @Value("${app.code}")
    private String code;

    @Autowired
    private IUserinfoService uf;

    @Autowired
    private  IUserService us;

    @RequestMapping(value = "/alluserinfo", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Userinfo> alluser() {
        System.out.print("----------------进入查询全部");
        return uf.selectAlluserinfo();
    }
    //id查询功能
    @RequestMapping(value = "/userinfouid/{uidd}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Userinfo userinfouid(@PathVariable(value = "uidd") Integer uid){
        System.out.println("------------进入id查询uuid="+uid);

        Userinfo userinfo = uf.selectByuid(uid);
        System.out.println("-----------userinfo="+userinfo);
        if (userinfo!=null){
            return userinfo;

        }
        return new Userinfo();
    }

    //修改
    @RequestMapping(value = "/updateuserinfo",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updateuserinfo(@RequestParam Map<String,Object> mp){

        System.out.println("------------进入到修改"+mp);
        //隐藏域有id，在通过id找到原来的数据
        String uid =(String) mp.get("uid");//在map里面获得uid
       Userinfo uu=uf.selectByuid(Integer.valueOf(uid));
        //加载需要修改数据
        /**
         * 1.通过map接受年月日和uesrid
         * 2.将年月日转化成data属性的生日
         * 3.通过usid获取到userinfo
         * 4.将获取的userinf对象的生日属性赋新值
         * 5.通过方法更新userinfo数据
         */
          String gender =(String)mp.get("gender") ;//在map里面获得类型
          uu.setGender(Integer.valueOf(gender));

        String year =(String)mp.get("year");
        String month =(String)mp.get("month");
        String days =(String)mp.get("days");
        String date = year+"-"+month+"-"+days+" 12:00:01";
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date  d =sdf.parse(date);
            uu.setBirthday(d);
        }catch (Exception e){
            System.out.println(e);
        }



        Integer num=uf.updateByPrimaryKey(uu);
        return num;
    }
}
