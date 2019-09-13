package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.CouponParam;
import cn.wpin.mall.sale.entity.Coupon;
import cn.wpin.mall.sale.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优惠券管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "优惠券管理")
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation("添加优惠券")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int add(@RequestBody CouponParam couponParam) {
        return couponService.create(couponParam);
    }

    @ApiOperation("删除优惠券")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return couponService.delete(id);
    }

    @ApiOperation("修改优惠券")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody CouponParam couponParam) {
        return couponService.update(id, couponParam);
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<Coupon> list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Coupon> couponList = couponService.list(name, type, pageSize, pageNum);
        return CommonPage.restPage(couponList);
    }

    @ApiOperation("获取单个优惠券的详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CouponParam getItem(@PathVariable Long id) {
        return couponService.getItem(id);
    }
}
