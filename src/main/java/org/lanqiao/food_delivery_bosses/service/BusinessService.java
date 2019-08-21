package org.lanqiao.food_delivery_bosses.service;


import org.lanqiao.food_delivery_bosses.mapper.AdvertisementMapper;
import org.lanqiao.food_delivery_bosses.mapper.BusinessMapper;
import org.lanqiao.food_delivery_bosses.pojo.Advertisement;
import org.lanqiao.food_delivery_bosses.pojo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service
@CacheConfig(cacheNames = "BusinessCache")
public class BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    private Business business;
    private HttpSession session;

    @Cacheable(value = "BusinessOneId",key = "targetClass+getMethodName()")
    public Business getOneById(String bId){
        return businessMapper.selectBusinessById(bId);
    }

    @Cacheable(value = "BusinessOneName",key = "targetClass+getMethodName()" )
    public Business getOneByName(String bName){
        return businessMapper.selectBusinessByName(bName);
    }

    @Cacheable(value = "isExitByName",key = "targetClass+getMethodName()")
    public String isExitByName(String bName){
        Business pwd = businessMapper.selectBusinessByName(bName);
        if(pwd != null){
            return pwd.getPassword();
        }else{
            return "没有这个店";
        }
    }

    @Cacheable(value = "registered",key = "targetClass+getMethodName()")
    public void registered(String bId, String bName, String password, String bTel, String bEmail, String key, String bossName, Integer age, String sex, String address, BigDecimal balance, String bPicture, String bLogo, BigDecimal bDelivery){
        Business b = business.builder().bId(bId).bName(bName).password(password).bTel(bTel).bEmail(bEmail).key(key).bossName(bossName).age(age).sex(sex).address(address).balance(balance).bPicture(bPicture).bLogo(bLogo).bDelivery(bDelivery).build();
        businessMapper.insert(b);
    }

    //判断店名是否重复
    @Cacheable(value = "judge",key = "targetClass+getMethodName()")
    public boolean isExit(String bName){
        Business b = businessMapper.selectBusinessByName(bName);
        if(b != null){
            return true;
        }
        return false;
    }

    @Cacheable(value = "update",key = "targetClass+getMethodName()")
    //修改商家不重要信息
    public void updateBusiness(Business business){
        businessMapper.updateBySome(business);
    }
}
