package cn.wpin.mall.sale.dto;


import cn.wpin.mall.sale.entity.Coupon;
import cn.wpin.mall.sale.entity.CouponProductCategoryRelation;
import cn.wpin.mall.sale.entity.CouponProductRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 * @author wangpin 
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CouponParam extends Coupon {
    /**
     * 优惠券绑定的商品
     */
    private List<CouponProductRelation> productRelationList;

    /**
     * 优惠券绑定的商品分类
     */
    private List<CouponProductCategoryRelation> productCategoryRelationList;


}
