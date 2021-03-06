package cn.wpin.mall.client.sale;

import cn.wpin.mall.sale.dto.FlashPromotionSessionDetail;
import cn.wpin.mall.sale.entity.FlashPromotionSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface FlashPromotionSessionClient {

    /**
     * 添加场次
     */
    @RequestMapping(value = "flashSession/create", method = RequestMethod.POST)
    int create(@RequestBody FlashPromotionSession promotionSession);

    /**
     * 修改场次
     */
    @RequestMapping(value = "flashSession/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody FlashPromotionSession promotionSession);

    /**
     * 修改启用状态
     */
    @RequestMapping(value = "flashSession/update/status/{id}", method = RequestMethod.POST)
    int updateStatus(@PathVariable Long id, Integer status);

    /**
     * 删除场次
     */
    @RequestMapping(value = "flashSession/delete/{id}", method = RequestMethod.POST)
    int delete(@PathVariable Long id);

    /**
     * 获取场次详情
     */
    @RequestMapping(value = "flashSession/{id}", method = RequestMethod.GET)
    FlashPromotionSession getItem(@PathVariable Long id);

    /**
     * 获取全部场次
     */
    @RequestMapping(value = "flashSession/list", method = RequestMethod.GET)
    List<FlashPromotionSession> list();

    /**
     * 获取全部可选场次及其数量
     */
    @RequestMapping(value = "flashSession/selectList", method = RequestMethod.GET)
    List<FlashPromotionSessionDetail> selectList(@RequestParam Long flashPromotionId);

    /**
     * 获取下次场次信息
     */
    @RequestMapping(value = "flashSession/getNextFlash", method = RequestMethod.GET)
    FlashPromotionSession getNextFlashPromotionSession(@RequestParam Date date);


    /**
     * 根据时间获取秒杀场次
     */
    @RequestMapping(value = "flashSession/getFlash", method = RequestMethod.GET)
    FlashPromotionSession getFlashPromotionSession(@RequestParam Date date);
}
