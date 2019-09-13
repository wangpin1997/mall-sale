package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.FlashPromotionSession;
import cn.wpin.mall.sale.example.FlashPromotionSessionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlashPromotionSessionMapper {

    long countByExample(FlashPromotionSessionExample example);

    int deleteByExample(FlashPromotionSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlashPromotionSession record);

    int insertSelective(FlashPromotionSession record);

    List<FlashPromotionSession> selectByExample(FlashPromotionSessionExample example);

    FlashPromotionSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlashPromotionSession record, @Param("example") FlashPromotionSessionExample example);

    int updateByExample(@Param("record") FlashPromotionSession record, @Param("example") FlashPromotionSessionExample example);

    int updateByPrimaryKeySelective(FlashPromotionSession record);

    int updateByPrimaryKey(FlashPromotionSession record);
}