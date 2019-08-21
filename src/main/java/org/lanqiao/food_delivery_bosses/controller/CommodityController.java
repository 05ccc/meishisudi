package org.lanqiao.food_delivery_bosses.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.food_delivery_bosses.pojo.Commodity;
import org.lanqiao.food_delivery_bosses.service.BusinessService;
import org.lanqiao.food_delivery_bosses.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;
    private BusinessService businessService;
    //查询全部商品
@GetMapping("/commodities")
   public String getAll(Model model,@RequestParam(value = "pageNum",defaultValue ="1")Integer pageNum){
       PageHelper.startPage(pageNum,7);
       List<Commodity> commodities = commodityService.getAll();
       PageInfo<Commodity> page = new PageInfo<>(commodities);
       System.out.println(page.getSize());
       model.addAttribute("page",page);
       return "commodityList";
    }
   //根据商品id获取商品信息
    @GetMapping("/commodity/{comId}")
    public String getCommodity(@PathVariable Integer comId,ModelMap map){
       Commodity commodity = commodityService.getCommodityById(comId);
       map.addAttribute("commodity",commodity);
       return "updateCommodity";
    }
    //根据商品描述模糊查询
     @RequestMapping("/commoditie")
    public String getCommodityBydecribes(String describes,Model map,@RequestParam(value = "pageNum",defaultValue ="1")Integer pageNum){
        List<Commodity> commodities = null;
        if(!describes.equals("")&&describes!=null){
            PageHelper.startPage(pageNum,3);
            commodities = commodityService.getCommodityByDescribes(describes);
        }else{
            PageHelper.startPage(pageNum,7);
            commodities=commodityService.getAll();
         }
        PageInfo<Commodity> page = new PageInfo<>(commodities);
        map.addAttribute("page",page);
        map.addAttribute("describes",describes);
         //System.out.println(describes);
        return "commodityList";
    }

    //修改商品
    @PutMapping("/commodity")
    public String modifyCommodity(Commodity commodity){
       commodityService.updateCommodity(commodity);
       return "redirect:/commodities";
    }

    //删除商品
    @DeleteMapping("/commodity/{comId}")
    public String deleteCommodity(@PathVariable Integer comId){
       commodityService.deleteCommodityById(comId);
       return "redirect:/commodities";
    }
    //添加商品 进入添加页面
    @GetMapping("/commodity")
    public String initAdd(Model model){
        return "updateCommodity";
    }
    @PostMapping("/commodity")
    public String insertCommodity(Commodity commodity){
        commodityService.insertCommodity(commodity);
        return "redirect:/commodities";
    }
}
