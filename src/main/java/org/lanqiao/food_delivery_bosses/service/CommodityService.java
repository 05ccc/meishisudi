package org.lanqiao.food_delivery_bosses.service;

import org.lanqiao.food_delivery_bosses.mapper.CommodityMapper;
import org.lanqiao.food_delivery_bosses.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {
 @Autowired
  private CommodityMapper commodityMapper;
    //查询全部商品
  public List<Commodity> getAll(){
    return commodityMapper.selectAll();
 }
    //根据商品描述模糊查询
   public List<Commodity> getCommodityByDescribes(String describes){
      return commodityMapper.selectCommodityByDescribes(describes);
   }
    //根据商品类型查询
    public List<Commodity> getCommodityByType(String type){
      return commodityMapper.selectCommodityByType(type);
    }
   /* public List<Commodity> getCommodityByContion(String describes,String type){
      return commodityMapper.selectCommodityByContion(describes,type);
    }*/
    //根据商品id查询
    public Commodity getCommodityById(Integer comId){
      return commodityMapper.selectCommodityById(comId);
    }
    //添加商品SPU
    public void insertCommodity(Commodity commodity){
      commodityMapper.insertCommodity(commodity);
    }
    //删除商品SPU
    public int deleteCommodityById(Integer comId){
      return commodityMapper.deleteCommodityById(comId);
    }
    //修改商品信息
    public void updateCommodity(Commodity commodity){
       commodityMapper.updateCommodity(commodity);
    }

}
