package cn.wpin.mall.sale.dao;

import cn.wpin.mall.sale.dto.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 限时购商品关联自定义Dao
 * @author wangpin
 */
public interface FlashPromotionProductRelationDao {
    /**
     * 获取限时购及相关商品信息
     */
    List<FlashPromotionProduct> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
