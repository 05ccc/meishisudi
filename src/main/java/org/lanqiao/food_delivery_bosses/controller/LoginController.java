package org.lanqiao.food_delivery_bosses.controller;


import org.lanqiao.food_delivery_bosses.pojo.Business;
import org.lanqiao.food_delivery_bosses.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private BusinessService businessService;
    private Business business;
    //登录
    @RequestMapping("/login")
    public  String login(String username, String password, Model model, HttpSession session){
        Business user =null;
        String str = businessService.isExitByName(username);
        if (str.equals(password)){
            session.setAttribute("username",username);
            return  "redirect:/main.html";
        }else if(str.equals("没有这个店")){
            model.addAttribute("msg",str);
            return  "index";
        }else {
            model.addAttribute("msg","密码错误");
            return  "index";
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }

    //注册
    @RequestMapping("/registered")
    public String registeredBusiness(String bId, String bName, String password, String bTel, String bEmail, String key, String bossName, Integer age, String sex, String address, BigDecimal balance, String bPicture, String bLogo, BigDecimal bDelivery,Model model,HttpSession session){
        boolean flag = businessService.isExit(bName);
        if (flag != true){
            businessService.registered(bId,bName,password,bTel,bEmail,key,bossName,age,sex,address,balance,bPicture,bLogo,bDelivery);
            return "index";
        }else{
            model.addAttribute("msg","该店铺名已存在，请换一个！");
            return "registered";
        }
    }

 }
