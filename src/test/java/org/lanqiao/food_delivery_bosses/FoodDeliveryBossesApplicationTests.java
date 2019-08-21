package org.lanqiao.food_delivery_bosses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanqiao.food_delivery_bosses.mapper.BusinessMapper;
import org.lanqiao.food_delivery_bosses.pojo.Business;
import org.lanqiao.food_delivery_bosses.service.BusinessService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@MapperScan("org.lanqiao.food_delivery_bosses")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodDeliveryBossesApplicationTests {
    @Autowired
    private BusinessService b;
    private Business business;
    @Test
    public void contextLoads() {
//        Business bc = b.getOneByName("老北京炸酱面");
//        System.out.println("=============================" + bc);
//        Business bb = b.getOneById("18200110022");
//        System.out.println("11111111111111111111111111111" + bb);

//        String str = b.registered("18234109953","天下第一面","123456","18234109953","123456@email.com","123456","张三丰",98,"男","北京",new BigDecimal(9.0),"f9.png","f9.jpg",new BigDecimal(18.7));
//        System.out.println(str);

    }
//    @Autowired
//    private BusinessMapper businessMapper1;
//    @Test
//    public void contextLoads6(){
//        BigDecimal bigDecimal = BigDecimal.valueOf(0.00);
//        BigDecimal bigDecimal2 = BigDecimal.valueOf(0.00);
////        Business userCustomer = Business.builder().bId("123").bName("123").bTel("123").password("123456").key("123456").balance(bigDecimal).bDelivery(bigDecimal2).build();
//        System.out.println(userCustomer);
//        businessMapper1.insert(userCustomer);
//    }
    @Autowired
    private BusinessService businessService;
    @Test
    public void Test(){
//        businessService.updateBusiness("18234109953","天下第一面","123456","18234109953","123456@email.com","123456","张三丰",98,"男","北京",new BigDecimal(9.0),"f9.png","f9.jpg",new BigDecimal(18.0));
//        Business b = businessService.getOneById("18234109953");
//        System.out.println(b);
//        businessService.updateBusiness("123456","18234109953","123456@email.com","123456","张三丰",98,"男","北京",new BigDecimal(9.0),"f9.png","f9.jpg",new BigDecimal(18.0));
       BigDecimal bigDecimal = BigDecimal.valueOf(12.00);
       BigDecimal bigDecimal2 = BigDecimal.valueOf(11.00);
       Business userCustomer = Business.builder().bId("123").bName("离子火花").bTel("123").password("123456").key("123456").balance(bigDecimal).bDelivery(bigDecimal2).build();
       businessService.updateBusiness(userCustomer);
    }
}
