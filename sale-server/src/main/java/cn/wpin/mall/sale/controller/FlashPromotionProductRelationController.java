package cn.wpin.mall.sale.controller;


import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.FlashPromotionProduct;
import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import cn.wpin.mall.sale.service.FlashPromotionProductRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 限时购和商品关系管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "限时购和商品关系管理")
@RequestMapping("/flashProductRelation")
public class FlashPromotionProductRelationController {

    @Autowired
    private FlashPromotionProductRelationService relationService;

    @ApiOperation("批量选择商品添加关联")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody List<FlashPromotionProductRelation> relationList) {
        return relationService.create(relationList);
    }

    @ApiOperation("修改关联相关信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody FlashPromotionProductRelation relation) {
        return relationService.update(id, relation);
    }

    @ApiOperation("删除关联")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return relationService.delete(id);
    }

    @ApiOperation("获取管理商品促销信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FlashPromotionProductRelation getItem(@PathVariable Long id) {
        return relationService.getItem(id);
    }

    @ApiOperation("分页查询不同场次关联及商品信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<FlashPromotionProduct> list(@RequestParam(value = "flashPromotionId") Long flashPromotionId,
                                                  @RequestParam(value = "flashPromotionSessionId") Long flashPromotionSessionId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FlashPromotionProduct> flashPromotionProductList = relationService.list(flashPromotionId, flashPromotionSessionId, pageSize, pageNum);
        return CommonPage.restPage(flashPromotionProductList);
    }
}
