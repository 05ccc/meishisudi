package org.lanqiao.food_delivery_bosses.pojo;
import lombok.Data;

@Data
public class Coupon {
    private Integer coupon;
    private String describes;
    private Integer condition;
    private Integer amount;
    private String icon;
    private Integer number;
}
