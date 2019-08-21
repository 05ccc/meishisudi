package org.lanqiao.food_delivery_bosses.pojo;

import lombok.Data;

@Data
public class CommodityComment {
    private Integer comment;
    private String userId;
    private String userName;
    private String content;

}
