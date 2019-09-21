package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.portal.entity.CartPromotionItem;
import cn.wpin.mall.portal.entity.CouponHistoryDetail;
import cn.wpin.mall.sale.entity.CouponHistory;
import cn.wpin.mall.user.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface MemberCouponClient {

    /**
     * 领取指定优惠券
     */
    @RequestMapping(value = "/add/{couponId}", method = RequestMethod.POST)
    CommonResult add(@PathVariable Long couponId, @RequestBody Member member);

    /**
     * 获取用户优惠券列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    CommonResult<List<CouponHistory>> list(@RequestParam(value = "useStatus", required = false) Integer useStatus,
                                           @RequestBody Member member);

    /**
     * 获取登录会员购物车的相关优惠券
     */
    @RequestMapping(value = "/list/cart/{type}", method = RequestMethod.GET)
    CommonResult<List<CouponHistoryDetail>> listCart(@RequestParam List<CartPromotionItem> cartList,
                                                     @PathVariable Integer type,
                                                     @RequestBody Member member);
}
