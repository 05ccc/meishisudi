package org.lanqiao.food_delivery_bosses.pojo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Business {
    private String bId;
    private String bName;
    private String password;
    private String bTel;
    private String bEmail;
    private String key;
    private String bossName;
    private Integer age;
    private String sex;
    private String address;
    private BigDecimal balance;
    private String bPicture;
    private String bLogo;
    private BigDecimal bDelivery;

    public Business(String bId, String bName, String password, String bTel, String bEmail, String key, String bossName, Integer age, String sex, String address, BigDecimal balance, String bPicture, String bLogo, BigDecimal bDelivery) {
        this.bId = bId;
        this.bName = bName;
        this.password = password;
        this.bTel = bTel;
        this.bEmail = bEmail;
        this.key = key;
        this.bossName = bossName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.balance = balance;
        this.bPicture = bPicture;
        this.bLogo = bLogo;
        this.bDelivery = bDelivery;
    }

    public Business() {
    }
}
