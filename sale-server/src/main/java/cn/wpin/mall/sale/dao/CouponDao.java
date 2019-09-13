package cn.wpin.mall.sale.dao;

import cn.wpin.mall.sale.dto.CouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * 优惠券管理自定义查询Dao
 * @author wangpin 
 */
public interface CouponDao {
    CouponParam getItem(@Param("id") Long id);
}
