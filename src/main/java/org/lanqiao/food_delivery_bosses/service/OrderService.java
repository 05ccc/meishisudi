package org.lanqiao.food_delivery_bosses.service;

import org.lanqiao.food_delivery_bosses.mapper.OrderMapper;
import org.lanqiao.food_delivery_bosses.mapper.OrderScheduleMapper;
import org.lanqiao.food_delivery_bosses.pojo.Order;
import org.lanqiao.food_delivery_bosses.pojo.OrderSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderScheduleMapper orderScheduleMapper;
    //查询全部订单
    public List<Order> getAllOrder(){
        return orderMapper.selAllOrders();
    }
    //根据订单id查询某一个订单信息
    public Order getOrderById(Integer ordId){
        return orderMapper.selOrderById(ordId);
    }
    //根据订单状态查询
    public List<Order> getOrderBySchedule(String schedule){
        return  orderMapper.selOrderBySchedule(schedule);
    }

    public void updateOrder(Order order){
        orderMapper.updateOrder(order);
    }

    public List<OrderSchedule> getAllOrderSchedules(){
        return orderScheduleMapper.selAllOrderSchedules();
    }
}
