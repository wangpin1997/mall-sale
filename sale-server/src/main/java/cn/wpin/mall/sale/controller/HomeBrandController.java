package cn.wpin.mall.sale.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeBrand;
import cn.wpin.mall.sale.service.HomeBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页品牌管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "首页品牌管理")
@RequestMapping("/home/brand")
public class HomeBrandController {

    @Autowired
    private HomeBrandService homeBrandService;

    @ApiOperation("添加首页推荐品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody List<HomeBrand> homeBrandList) {
        return homeBrandService.create(homeBrandList);
    }

    @ApiOperation("修改品牌排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    public int updateSort(@PathVariable Long id, @RequestParam Integer sort) {
        return homeBrandService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return homeBrandService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        return homeBrandService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐品牌")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<HomeBrand> list(@RequestParam(value = "brandName", required = false) String brandName,
                                      @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeBrand> homeBrandList = homeBrandService.list(brandName, recommendStatus, pageSize, pageNum);
        return CommonPage.restPage(homeBrandList);
    }
}
