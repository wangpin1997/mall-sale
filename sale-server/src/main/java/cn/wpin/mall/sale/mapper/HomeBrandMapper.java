package cn.wpin.mall.sale.mapper;


import cn.wpin.mall.sale.entity.HomeBrand;
import cn.wpin.mall.sale.example.HomeBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeBrandMapper {

    long countByExample(HomeBrandExample example);

    int deleteByExample(HomeBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeBrand record);

    int insertSelective(HomeBrand record);

    List<HomeBrand> selectByExample(HomeBrandExample example);

    HomeBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeBrand record, @Param("example") HomeBrandExample example);

    int updateByExample(@Param("record") HomeBrand record, @Param("example") HomeBrandExample example);

    int updateByPrimaryKeySelective(HomeBrand record);

    int updateByPrimaryKey(HomeBrand record);
}