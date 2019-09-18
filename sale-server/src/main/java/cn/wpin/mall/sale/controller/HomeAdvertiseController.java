package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeAdvertise;
import cn.wpin.mall.sale.service.HomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页轮播广告管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "首页轮播广告管理")
@RequestMapping("/home/advertise")
public class HomeAdvertiseController {

    @Autowired
    private HomeAdvertiseService advertiseService;

    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody HomeAdvertise advertise) {
        return advertiseService.create(advertise);
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return advertiseService.delete(ids);
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    public int updateStatus(@PathVariable Long id, Integer status) {
        return advertiseService.updateStatus(id, status);
    }

    @ApiOperation("获取广告详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HomeAdvertise getItem(@PathVariable Long id) {
        return advertiseService.getItem(id);
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody HomeAdvertise advertise) {
        return advertiseService.update(id, advertise);
    }

    @ApiOperation("分页查询广告")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<HomeAdvertise> list(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "type", required = false) Integer type,
                                          @RequestParam(value = "endTime", required = false) String endTime,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeAdvertise> advertiseList = advertiseService.list(name, type, endTime, pageSize, pageNum);
        return CommonPage.restPage(advertiseList);
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "getHomeAdvertiseList", method = RequestMethod.POST)
    public List<HomeAdvertise> getHomeAdvertiseList() {
        return advertiseService.getHomeAdvertiseList();
    }


}
