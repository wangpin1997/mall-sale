package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendProduct;
import cn.wpin.mall.sale.service.HomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页人气推荐管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "首页人气推荐管理")
@RequestMapping("/home/recommendProduct")
public class HomeRecommendProductController {
    @Autowired
    private HomeRecommendProductService recommendProductService;

    @ApiOperation("添加首页推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody List<HomeRecommendProduct> homeBrandList) {
        return recommendProductService.create(homeBrandList);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    public int updateSort(@PathVariable Long id,@RequestParam Integer sort) {
        return recommendProductService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return recommendProductService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        return recommendProductService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<HomeRecommendProduct> list(@RequestParam(value = "productName", required = false) String productName,
                                                 @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeRecommendProduct> homeBrandList = recommendProductService.list(productName, recommendStatus, pageSize, pageNum);
        return CommonPage.restPage(homeBrandList);
    }
}
