package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeNewProduct;
import cn.wpin.mall.sale.service.HomeNewProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页新品管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "首页新品管理")
@RequestMapping("/home/newProduct")
public class HomeNewProductController {
    @Autowired
    private HomeNewProductService homeNewProductService;

    @ApiOperation("添加首页推荐品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody List<HomeNewProduct> homeBrandList) {
        return homeNewProductService.create(homeBrandList);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    public int updateSort(@PathVariable Long id,@RequestParam Integer sort) {
        return homeNewProductService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return homeNewProductService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        return homeNewProductService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<HomeNewProduct> list(@RequestParam(value = "productName", required = false) String productName,
                                           @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeNewProduct> homeBrandList = homeNewProductService.list(productName, recommendStatus, pageSize, pageNum);
        return CommonPage.restPage(homeBrandList);
    }
}
