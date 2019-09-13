package cn.wpin.mall.sale.mapper;


import cn.wpin.mall.sale.entity.HomeNewProduct;
import cn.wpin.mall.sale.example.HomeNewProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeNewProductMapper {

    long countByExample(HomeNewProductExample example);

    int deleteByExample(HomeNewProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeNewProduct record);

    int insertSelective(HomeNewProduct record);

    List<HomeNewProduct> selectByExample(HomeNewProductExample example);

    HomeNewProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeNewProduct record, @Param("example") HomeNewProductExample example);

    int updateByExample(@Param("record") HomeNewProduct record, @Param("example") HomeNewProductExample example);

    int updateByPrimaryKeySelective(HomeNewProduct record);

    int updateByPrimaryKey(HomeNewProduct record);
}