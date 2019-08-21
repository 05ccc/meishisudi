package org.lanqiao.food_delivery_bosses.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.food_delivery_bosses.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    //查询全部订单
    public List<Order> selAllOrders();
    //根据订单id查询订单信息
    public Order selOrderById(Integer ordId);

    //根据订单状态查询订单
    public List<Order> selOrderBySchedule(String schedule);
    //修改订单状态
    public void updateOrder(Order order);
}
