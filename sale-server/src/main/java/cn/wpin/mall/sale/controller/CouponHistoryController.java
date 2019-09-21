package cn.wpin.mall.sale.controller;


import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.CouponHistory;
import cn.wpin.mall.sale.example.CouponHistoryExample;
import cn.wpin.mall.sale.service.CouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优惠券领取记录管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "优惠券领取记录管理")
@RequestMapping("/couponHistory")
public class CouponHistoryController {

    @Autowired
    private CouponHistoryService historyService;

    @ApiOperation("根据优惠券id，使用状态，订单编号分页获取领取记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<CouponHistory> list(@RequestParam(value = "couponId", required = false) Long couponId,
                                          @RequestParam(value = "useStatus", required = false) Integer useStatus,
                                          @RequestParam(value = "orderSn", required = false) String orderSn,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CouponHistory> historyList = historyService.list(couponId, useStatus, orderSn, pageSize, pageNum);
        return CommonPage.restPage(historyList);
    }



    @PostMapping("updateCouponStatus")
    public void updateCouponStatus(@RequestParam Long couponId,
                                   @RequestParam Long memberId,
                                   @RequestParam Integer useStatus) {
         historyService.updateCouponStatus(couponId, memberId, useStatus);
    }
}
