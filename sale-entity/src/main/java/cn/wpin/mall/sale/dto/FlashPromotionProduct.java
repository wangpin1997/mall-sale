package cn.wpin.mall.sale.dto;

import cn.wpin.mall.product.entity.Product;
import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 限时购及商品信息封装
 *
 * @author wangpin
 * @date 2019/09/13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FlashPromotionProduct extends FlashPromotionProductRelation {

    private Product product;
}
