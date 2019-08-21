package org.lanqiao.food_delivery_bosses.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.food_delivery_bosses.pojo.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommodityMapper {
    //查询全部商品
    public List<Commodity> selectAll();
   /* //查询商品的总记录数
    public Integer selectCount();
    //跳到第几页
    public List<Commodity> selectPage(Map map);*/
    //根据商品描述模糊查询
    public List<Commodity> selectCommodityByDescribes(String describes);
    //根据商品类型查询
    public List<Commodity> selectCommodityByType(String type);
    //
    //public List<Commodity> selectCommodityByContion(@Param("describes") String describes,@Param("type") String type);
   //根据商品id查询
    public Commodity selectCommodityById(Integer comId);
   //添加商品SPU
    public void insertCommodity(Commodity commodity);
   //删除商品SPU
    public int deleteCommodityById(Integer comId);
   //修改商品信息
    public void updateCommodity(Commodity commodity);

}
