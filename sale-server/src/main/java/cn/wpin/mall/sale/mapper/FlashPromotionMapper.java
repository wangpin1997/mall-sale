package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.FlashPromotion;
import cn.wpin.mall.sale.example.FlashPromotionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlashPromotionMapper {
    long countByExample(FlashPromotionExample example);

    int deleteByExample(FlashPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlashPromotion record);

    int insertSelective(FlashPromotion record);

    List<FlashPromotion> selectByExample(FlashPromotionExample example);

    FlashPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlashPromotion record, @Param("example") FlashPromotionExample example);

    int updateByExample(@Param("record") FlashPromotion record, @Param("example") FlashPromotionExample example);

    int updateByPrimaryKeySelective(FlashPromotion record);

    int updateByPrimaryKey(FlashPromotion record);
}