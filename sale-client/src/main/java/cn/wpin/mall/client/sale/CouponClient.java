package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.CouponParam;
import cn.wpin.mall.sale.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface CouponClient {

    /**
     * 添加优惠券
     */
    @RequestMapping(value = "coupon/create", method = RequestMethod.POST)
    int add(@RequestBody CouponParam couponParam);

    /**
     * 删除优惠券
     */
    @RequestMapping(value = "coupon/delete/{id}", method = RequestMethod.POST)
    int delete(@PathVariable Long id);


    /**
     * 修改优惠券
     */
    @RequestMapping(value = "coupon/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody CouponParam couponParam);

    /**
     * 根据优惠券名称和类型分页获取优惠券列表
     */
    @RequestMapping(value = "coupon/list", method = RequestMethod.GET)
    CommonPage<Coupon> list(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 获取单个优惠券的详细信息
     */
    @RequestMapping(value = "coupon/{id}", method = RequestMethod.GET)
    CouponParam getItem(@PathVariable Long id);
}
