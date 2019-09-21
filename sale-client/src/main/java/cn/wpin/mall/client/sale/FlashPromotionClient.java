package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.FlashPromotion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface FlashPromotionClient {

    /**
     * 添加活动
     */
    @RequestMapping(value = "flash/create", method = RequestMethod.POST)
    int create(@RequestBody FlashPromotion flashPromotion);

    /**
     * 编辑活动信息
     */
    @RequestMapping(value = "flash/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody FlashPromotion flashPromotion);

    /**
     * 删除活动信息
     */
    @RequestMapping(value = "flash/delete/{id}", method = RequestMethod.POST)
    int delete(@PathVariable Long id);

    /**
     * 修改上下线状态
     */
    @RequestMapping(value = "flash/update/status/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id,@RequestParam Integer status);

    /**
     * 获取活动详情
     */
    @RequestMapping(value = "flash/{id}", method = RequestMethod.GET)
    FlashPromotion getItem(@PathVariable Long id);

    /**
     * 根据活动名称分页查询
     */
    @RequestMapping(value = "flash/list", method = RequestMethod.GET)
    CommonPage<FlashPromotion> getItem(@RequestParam(value = "keyword") String keyword,
                                       @RequestParam(value = "pageSize") Integer pageSize,
                                       @RequestParam(value = "pageNum") Integer pageNum);


    /**
     * 根据时间获取秒杀活动
     */
    @RequestMapping(value = "flash/getFlashPromotion", method = RequestMethod.GET)
    FlashPromotion getFlashPromotion(@RequestParam Date date);
}
