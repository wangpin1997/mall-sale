package cn.wpin.mall.sale.dao;

import cn.wpin.mall.portal.entity.CouponHistoryDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 * @author wangpin
 */
public interface CouponHistoryDao {
    List<CouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);
}
