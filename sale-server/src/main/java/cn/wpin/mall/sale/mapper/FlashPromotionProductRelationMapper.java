package cn.wpin.mall.sale.mapper;


import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import cn.wpin.mall.sale.example.FlashPromotionProductRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlashPromotionProductRelationMapper {
    long countByExample(FlashPromotionProductRelationExample example);

    int deleteByExample(FlashPromotionProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlashPromotionProductRelation record);

    int insertSelective(FlashPromotionProductRelation record);

    List<FlashPromotionProductRelation> selectByExample(FlashPromotionProductRelationExample example);

    FlashPromotionProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlashPromotionProductRelation record, @Param("example") FlashPromotionProductRelationExample example);

    int updateByExample(@Param("record") FlashPromotionProductRelation record, @Param("example") FlashPromotionProductRelationExample example);

    int updateByPrimaryKeySelective(FlashPromotionProductRelation record);

    int updateByPrimaryKey(FlashPromotionProductRelation record);
}