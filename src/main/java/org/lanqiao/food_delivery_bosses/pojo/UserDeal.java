package org.lanqiao.food_delivery_bosses.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDeal {
    private Integer userDeal;
    private String userId;
    private Integer comId;
    private Integer ordId;
    private String bId;
    private BigDecimal balance;
}
