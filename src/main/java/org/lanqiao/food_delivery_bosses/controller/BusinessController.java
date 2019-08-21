package org.lanqiao.food_delivery_bosses.controller;

import org.lanqiao.food_delivery_bosses.pojo.Business;
import org.lanqiao.food_delivery_bosses.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Collection;

@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    //显示商家所有信息
    @GetMapping("/businessInfo")
    public String getBusiness(HttpSession session, ModelMap map){
        String bName = (String) session.getAttribute("username");
        Business b =businessService.getOneByName(bName);
        System.out.println(b);
        map.addAttribute("business",b);
        return "businessInfo";
    }

    @GetMapping("/updateBusiness/{bName}")
    public String getBusiness( HttpSession session, ModelMap map,@PathVariable String bName){
        bName = (String) session.getAttribute("username");
        Business b =businessService.getOneByName(bName);
        map.addAttribute("business",b);
        return "updateBusiness";
    }

    @PutMapping("/updateBusiness")
    public String modifyBusiness(Business b){
//        Business b2 = b.builder().bId(bId).bName(bName).password(password).bTel(bTel).bEmail(bEmail).key(key).bossName(bossName).age(age).sex(sex).address(address).balance(balance).bPicture(bPicture).bLogo(bLogo).bDelivery(bDelivery).build();
        businessService.updateBusiness(b);
        return "redirect:/businessInfo";
//        ,String bId, String bName, String password, String bTel, String bEmail, String key, String bossName, Integer age, String sex, String address, BigDecimal balance, String bPicture, String bLogo, BigDecimal bDelivery
    }


}
