package cn.wpin.mall.sale.dto;

import cn.wpin.mall.sale.entity.FlashPromotionSession;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包含商品数量的场次信息
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FlashPromotionSessionDetail extends FlashPromotionSession {

    private Long productCount;
}
