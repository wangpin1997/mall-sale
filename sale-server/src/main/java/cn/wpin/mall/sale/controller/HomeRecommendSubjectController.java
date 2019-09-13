package cn.wpin.mall.sale.controller;


import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendSubject;
import cn.wpin.mall.sale.service.HomeRecommendSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页专题推荐管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "首页专题推荐管理")
@RequestMapping("/home/recommendSubject")
public class HomeRecommendSubjectController {

    @Autowired
    private HomeRecommendSubjectService recommendSubjectService;

    @ApiOperation("添加首页推荐专题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody List<HomeRecommendSubject> homeBrandList) {
        return recommendSubjectService.create(homeBrandList);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    public int updateSort(@PathVariable Long id, Integer sort) {
        return recommendSubjectService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return recommendSubjectService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        return recommendSubjectService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<HomeRecommendSubject> list(@RequestParam(value = "subjectName", required = false) String subjectName,
                                                 @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeRecommendSubject> homeBrandList = recommendSubjectService.list(subjectName, recommendStatus, pageSize, pageNum);
        return CommonPage.restPage(homeBrandList);
    }
}
