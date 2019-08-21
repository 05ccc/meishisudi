package org.lanqiao.food_delivery_bosses.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Commodity {
    private Integer comId;
    private String comName;
    private String type;
    private String bId;
    private String size;
    private BigDecimal price;
    private String describes;
    private String picture;

    public Commodity() {
    }

    public Commodity(Integer comId, String comName, String type, String describes, String picture) {
        this.comId = comId;
        this.comName = comName;
        this.type = type;
        this.describes = describes;
        this.picture = picture;
    }

    public Commodity(Integer comId, String comName, String size, BigDecimal price, String describes) {
        this.comId = comId;
        this.comName = comName;
        this.size = size;
        this.price = price;
        this.describes = describes;
    }

    public Commodity(String comName, String type, String bId, String size, BigDecimal price, String describes, String picture) {
        this.comName = comName;
        this.type = type;
        this.bId = bId;
        this.size = size;
        this.price = price;
        this.describes = describes;
        this.picture = picture;
    }

    public Commodity(Integer comId, String comName, String type, String bId, String size, BigDecimal price, String describes, String picture) {
        this.comId = comId;
        this.comName = comName;
        this.type = type;
        this.bId = bId;
        this.size = size;
        this.price = price;
        this.describes = describes;
        this.picture = picture;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", type='" + type + '\'' +
                ", bId='" + bId + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", describes='" + describes + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
