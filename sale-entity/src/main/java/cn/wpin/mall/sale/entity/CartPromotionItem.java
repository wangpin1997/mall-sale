package cn.wpin.mall.sale.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author wangpin
 * 购物车中促销信息的封装
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CartPromotionItem extends CartItem {

    /**
     * 促销活动信息
     */
    private String promotionMessage;

    /**
     * 促销活动减去的金额，针对每个商品
     */
    private BigDecimal reduceAmount;

    /**
     * 商品的真实库存（剩余库存-锁定库存）
     */
    private Integer realStock;

    /**
     * 购买商品赠送积分
     */
    private Integer integration;

    /**
     * 购买商品赠送成长值
     */
    private Integer growth;
}
