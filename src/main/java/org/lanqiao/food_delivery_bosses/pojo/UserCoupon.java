package org.lanqiao.food_delivery_bosses.pojo;

import lombok.Data;

@Data
public class UserCoupon {
    private Integer couponId;
    private Integer coupon;
    private String userId;
    private String describe;
}
