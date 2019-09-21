package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.FlashPromotion;
import cn.wpin.mall.sale.service.FlashPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 限时购活动管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "限时购活动管理")
@RequestMapping("/flash")
public class FlashPromotionController {
    @Autowired
    private FlashPromotionService flashPromotionService;

    @ApiOperation("添加活动")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody FlashPromotion flashPromotion) {
        return flashPromotionService.create(flashPromotion);
    }

    @ApiOperation("编辑活动信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody FlashPromotion flashPromotion) {
        return flashPromotionService.update(id, flashPromotion);
    }

    @ApiOperation("删除活动信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return flashPromotionService.delete(id);
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id,@RequestParam Integer status) {
        return flashPromotionService.updateStatus(id, status);
    }

    @ApiOperation("获取活动详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FlashPromotion getItem(@PathVariable Long id) {
        return flashPromotionService.getItem(id);
    }

    @ApiOperation("根据活动名称分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<FlashPromotion> getItem(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FlashPromotion> flashPromotionList = flashPromotionService.list(keyword, pageSize, pageNum);
        return CommonPage.restPage(flashPromotionList);
    }

    @ApiOperation("根据时间获取秒杀活动")
    @RequestMapping(value = "/getFlashPromotion", method = RequestMethod.GET)
    public FlashPromotion getFlashPromotion(@RequestParam Date date) {
        return flashPromotionService.getFlashPromotion(date);
    }

}
