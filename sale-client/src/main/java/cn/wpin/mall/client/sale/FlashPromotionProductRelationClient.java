package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.FlashPromotionProduct;
import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface FlashPromotionProductRelationClient {

    /**
     * 批量选择商品添加关联
     *
     * @param relationList
     * @return
     */
    @RequestMapping(value = "flashProductRelation/create", method = RequestMethod.POST)
    int create(@RequestBody List<FlashPromotionProductRelation> relationList);

    /**
     * 修改关联相关信息
     *
     * @param id
     * @param relation
     * @return
     */
    @RequestMapping(value = "flashProductRelation/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody FlashPromotionProductRelation relation);

    /**
     * 删除关联
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "flashProductRelation/delete/{id}", method = RequestMethod.POST)
    int delete(@PathVariable Long id);

    /**
     * 获取管理商品促销信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "flashProductRelation/{id}", method = RequestMethod.GET)
    FlashPromotionProductRelation getItem(@PathVariable Long id);

    /**
     * 分页查询不同场次关联及商品信息
     *
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "flashProductRelation/list", method = RequestMethod.GET)
    CommonPage<FlashPromotionProduct> list(@RequestParam(value = "flashPromotionId") Long flashPromotionId,
                                           @RequestParam(value = "flashPromotionSessionId") Long flashPromotionSessionId,
                                           @RequestParam(value = "pageSize") Integer pageSize,
                                           @RequestParam(value = "pageNum") Integer pageNum);
}
