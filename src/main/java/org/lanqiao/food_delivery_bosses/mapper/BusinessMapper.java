package org.lanqiao.food_delivery_bosses.mapper;


import org.apache.ibatis.annotations.*;
import org.lanqiao.food_delivery_bosses.pojo.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BusinessMapper {
    @Select("select * from business where b_id=#{bId}")
    public Business selectBusinessById(String bId);

    @Select(value = "select * from business where b_name = '${bName}'")
    public Business selectBusinessByName(String bName);

    @Select("select * from business")
    public List<Business> selectAll();

    @Insert("insert into business(b_id,b_name,password,b_tel,b_email,b_key,boss_name,age,sex,address,balance,b_picture,b_logo,b_delivery)" +
            "values(#{bId},#{bName},#{password},#{bTel},#{bEmail},#{key},#{bossName},#{age},#{sex},#{address},#{balance},#{bPicture},#{bLogo},#{bDelivery})")
    public void insert(Business business);

    @Delete("delete from business where b_id=#{bId}")
    public void deleteBusinessById(String bId);

    @Update("update business set b_name=#{bName},password=#{password},b_tel=#{bTel}," +
            "b_email=#{bEmail},b_key=#{key},boss_name=#{bossName},age=#{age},sex=#{sex}," +
            "address=#{address},balance=#{balance},b_picture=#{bPicture},b_logo=#{bLogo},b_delivery=#{bDelivery}" +
            "where b_id=#{bId}")
    public void update(Business business);

    @Update("update business set b_id=#{bId},password=#{password},b_tel=#{bTel},b_email=#{bEmail},b_key=#{key},boss_name=#{bossName},age=#{age},sex=#{sex},"
            + "address=#{address},balance=#{balance},b_picture=#{bPicture},b_logo=#{bLogo},b_delivery=#{bDelivery} where b_name=#{bName}")
    public void updateBySome(Business business);
}

