package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.FlashPromotionLog;
import cn.wpin.mall.sale.example.FlashPromotionLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlashPromotionLogMapper {

    long countByExample(FlashPromotionLogExample example);

    int deleteByExample(FlashPromotionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlashPromotionLog record);

    int insertSelective(FlashPromotionLog record);

    List<FlashPromotionLog> selectByExample(FlashPromotionLogExample example);

    FlashPromotionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlashPromotionLog record, @Param("example") FlashPromotionLogExample example);

    int updateByExample(@Param("record") FlashPromotionLog record, @Param("example") FlashPromotionLogExample example);

    int updateByPrimaryKeySelective(FlashPromotionLog record);

    int updateByPrimaryKey(FlashPromotionLog record);
}