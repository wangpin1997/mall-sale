package cn.wpin.mall.sale.dao;

import cn.wpin.mall.sale.entity.CouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和商品分类关系自定义Dao
 * @author wangpin
 */
public interface CouponProductCategoryRelationDao {
    int insertList(@Param("list") List<CouponProductCategoryRelation> productCategoryRelationList);
}
