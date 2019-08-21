package org.lanqiao.food_delivery_bosses.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.food_delivery_bosses.pojo.OrderSchedule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderScheduleMapper {
    @Select("select* from order_schedule")
    public List<OrderSchedule> selAllOrderSchedules();
    @Select("select* from order_schedule where schedule = #{schedule}")
    public OrderSchedule selOrderScheduleById(String schedule);
}
