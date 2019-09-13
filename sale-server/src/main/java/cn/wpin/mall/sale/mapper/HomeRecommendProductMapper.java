package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.HomeRecommendProduct;
import cn.wpin.mall.sale.example.HomeRecommendProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeRecommendProductMapper {

    long countByExample(HomeRecommendProductExample example);

    int deleteByExample(HomeRecommendProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeRecommendProduct record);

    int insertSelective(HomeRecommendProduct record);

    List<HomeRecommendProduct> selectByExample(HomeRecommendProductExample example);

    HomeRecommendProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeRecommendProduct record, @Param("example") HomeRecommendProductExample example);

    int updateByExample(@Param("record") HomeRecommendProduct record, @Param("example") HomeRecommendProductExample example);

    int updateByPrimaryKeySelective(HomeRecommendProduct record);

    int updateByPrimaryKey(HomeRecommendProduct record);
}