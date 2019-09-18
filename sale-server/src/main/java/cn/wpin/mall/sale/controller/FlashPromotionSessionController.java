package cn.wpin.mall.sale.controller;

import cn.wpin.mall.sale.dto.FlashPromotionSessionDetail;
import cn.wpin.mall.sale.entity.FlashPromotionSession;
import cn.wpin.mall.sale.service.FlashPromotionSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 限时购场次管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "限时购场次管理")
@RequestMapping("/flashSession")
public class FlashPromotionSessionController {

    @Autowired
    private FlashPromotionSessionService flashPromotionSessionService;

    @ApiOperation("添加场次")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody FlashPromotionSession promotionSession) {
        return flashPromotionSessionService.create(promotionSession);
    }

    @ApiOperation("修改场次")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody FlashPromotionSession promotionSession) {
        return flashPromotionSessionService.update(id, promotionSession);
    }

    @ApiOperation("修改启用状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    public int updateStatus(@PathVariable Long id, Integer status) {
        return flashPromotionSessionService.updateStatus(id, status);
    }

    @ApiOperation("删除场次")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return flashPromotionSessionService.delete(id);
    }

    @ApiOperation("获取场次详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FlashPromotionSession getItem(@PathVariable Long id) {
        return flashPromotionSessionService.getItem(id);
    }

    @ApiOperation("获取全部场次")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<FlashPromotionSession> list() {
        return flashPromotionSessionService.list();
    }

    @ApiOperation("获取全部可选场次及其数量")
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    public List<FlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        return flashPromotionSessionService.selectList(flashPromotionId);
    }

    @ApiOperation("获取下次场次信息")
    @RequestMapping(value = "/getNextFlash", method = RequestMethod.GET)
    public FlashPromotionSession getNextFlashPromotionSession(Date date) {
        return flashPromotionSessionService.getNextFlashPromotionSession(date);
    }


    @ApiOperation("根据时间获取秒杀场次")
    @RequestMapping(value = "/getFlash", method = RequestMethod.GET)
    public FlashPromotionSession getFlashPromotionSession(Date date) {
        return flashPromotionSessionService.getFlashPromotionSession(date);
    }





}