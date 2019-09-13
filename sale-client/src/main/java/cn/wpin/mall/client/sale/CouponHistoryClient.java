package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.CouponHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface CouponHistoryClient {

    /**
     * 根据优惠券id，使用状态，订单编号分页获取领取记录
     */
    @RequestMapping(value = "couponHistory/list", method = RequestMethod.GET)
    CommonPage<CouponHistory> list(@RequestParam(value = "couponId") Long couponId,
                                   @RequestParam(value = "useStatus") Integer useStatus,
                                   @RequestParam(value = "orderSn") String orderSn,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "pageNum") Integer pageNum);
}
