package cn.wpin.mall.sale.dao;

import cn.wpin.mall.sale.entity.CouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和产品关系自定义Dao
 * @author wangpin
 */
public interface CouponProductRelationDao {
    int insertList(@Param("list") List<CouponProductRelation> productRelationList);
}
