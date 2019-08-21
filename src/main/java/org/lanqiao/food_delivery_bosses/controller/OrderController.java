package org.lanqiao.food_delivery_bosses.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.food_delivery_bosses.pojo.Order;
import org.lanqiao.food_delivery_bosses.pojo.OrderSchedule;
import org.lanqiao.food_delivery_bosses.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    //查询全部订单

    @GetMapping("/orders")
    public String getAll(Model model, @RequestParam(value = "pageNum",defaultValue ="1")Integer pageNum){
        PageHelper.startPage(pageNum,7);
        List<Order> orders = orderService.getAllOrder();
        PageInfo<Order> page = new PageInfo<>(orders);
        System.out.println(page.getSize());
        model.addAttribute("page",page);
        return "order";
    }

    //根据订单状态查询
    @RequestMapping("/orderl")
    public String getOrderBySchedule(String schedule,Model map,@RequestParam(value = "pageNum",defaultValue ="1")Integer pageNum){
        List<Order> orders = null;
        if(!schedule.equals("")&&schedule!=null){
            PageHelper.startPage(pageNum,3);
            orders=orderService.getOrderBySchedule(schedule);
        }else{
            PageHelper.startPage(pageNum,7);
            orders=orderService.getAllOrder();
        }
        PageInfo<Order> page = new PageInfo<>(orders);
        map.addAttribute("page",page);
        map.addAttribute("schedule",schedule);
        //System.out.println(schedule);
        return "order";
    }

    //根据订单id获取订单信息
    @GetMapping("/order/{ordId}")
    public String getOrder(@PathVariable Integer ordId, ModelMap map){
        Order order = orderService.getOrderById(ordId);
        List<OrderSchedule> orderSchedules = orderService.getAllOrderSchedules();
        map.addAttribute("order",order);
        map.addAttribute("orderSchedules",orderSchedules);
        return "updateOrder";
    }

    @PutMapping("/order")
    public String modifyOrder(Order order){
      orderService.updateOrder(order);
        return "redirect:/orders";
    }
}
