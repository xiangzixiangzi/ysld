package com.action;
import  com.entity.*;
import  com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import  java.util.*;
@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class ReceivingController {
    @Value("${app.code}")
    private String code;
    @Autowired
    private IReceivingService re;
    @Autowired
    private IQuserService qu;
    //新增
    @RequestMapping(value = "/addreceiving",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer addreceiving(@RequestParam Map<String,Object> mp){
        System.out.println("------------进入到新增"+mp);
        Receiving receiving =new Receiving();
        String id=(String) mp.get("uid");
        Integer uid=Integer.valueOf(id);
        String  province=(String)mp.get("s_province");
        String  city=(String)mp.get("s_city");
        String  county=(String)mp.get("s_county");
        String  raddress=(String)mp.get("raddress");
        String  adressStatus1=(String) mp.get("adressStatus");
        Integer adressStatus=Integer.valueOf(adressStatus1);

        String dizhi = province+city+county+raddress;
        receiving.setUid(uid);
        receiving.setRaddress(dizhi);
        receiving.setAdressstatus(adressStatus);
        int num =re.insert(receiving);
       /* System.out.println("-----"+receiving);*/
        if (num>0){
            /*取rid*/
            String  qname=(String) mp.get("qname");
            String  sex=(String) mp.get("sex");
            String  postal=(String) mp.get("postal");
            String  phone=(String) mp.get("phone");

            Quser quser =new Quser();
                  quser.setPostal(postal);
                  quser.setQname(qname);
                  quser.setSex(sex);
                  quser.setPhone(phone);
                  quser.setRid(receiving.getRid());
                  int num1=qu.insert(quser);

            return quser.getRid();
        }else {
            return 0;
        }

    }

    //修改

    @RequestMapping(value = "/updaterecr/{rid}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updaterecr(@PathVariable(value = "rid")Integer rid)throws  Exception{
        System.out.println("------------进入到修改");

        Receiving receiving = re.selectByPrimaryKey(rid);//先通过id找改(前端没有form表单)
        receiving.setAdressstatus(2);
        Integer num =re.updateByPrimaryKey(receiving);

        return  num;
    }


    //按UID查找
    @RequestMapping(value ="/receiuid/{uid}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,Object> receiuid(@PathVariable(value = "uid") Integer uid)throws Exception{
        System.out.println("----------------进入按uid查询");

        Map<String,Object> mp =new HashMap();
        List<Receiving> receivings = re.selectByuid(uid);
        List<Quser> quser=new ArrayList<>();
        mp.put("receivings",receivings);

     for (Receiving r:receivings){
        quser.add(qu.selectByrid(r.getRid())) ;
     }
        mp.put("quser",quser);
        return  mp;
    }

}
