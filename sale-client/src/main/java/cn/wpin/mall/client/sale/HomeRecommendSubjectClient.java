package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendSubject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface HomeRecommendSubjectClient {

    /**
     * 添加首页推荐专题
     *
     * @param homeBrandList
     * @return
     */
    @RequestMapping(value = "home/recommendSubject/create", method = RequestMethod.POST)
    int create(@RequestBody List<HomeRecommendSubject> homeBrandList);

    /**
     * 修改推荐排序
     *
     * @param id
     * @param sort
     * @return
     */
    @RequestMapping(value = "home/recommendSubject/update/sort/{id}", method = RequestMethod.POST)
    int updateSort(@PathVariable Long id, Integer sort);

    /**
     * 批量删除推荐
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "home/recommendSubject/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 批量修改推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    @RequestMapping(value = "home/recommendSubject/update/recommendStatus", method = RequestMethod.POST)
    int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                              @RequestParam Integer recommendStatus);

    /**
     * 分页查询推荐
     *
     * @param subjectName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "home/recommendSubject/list", method = RequestMethod.GET)
    CommonPage<HomeRecommendSubject> list(@RequestParam(value = "subjectName") String subjectName,
                                          @RequestParam(value = "recommendStatus") Integer recommendStatus,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "pageNum") Integer pageNum);
}
