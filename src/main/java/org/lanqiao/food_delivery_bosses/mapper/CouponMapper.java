package org.lanqiao.food_delivery_bosses.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.food_delivery_bosses.pojo.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CouponMapper {
    @Select("select* from coupon")
    public List<Coupon> selAllCoupons();
    @Select("select* from coupon where coupon = {#coupon}")
    public Coupon selCouponByType(Integer coupon);
}
