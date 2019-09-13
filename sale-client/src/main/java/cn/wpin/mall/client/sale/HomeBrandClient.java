package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeBrand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface HomeBrandClient {

    /**
     * 添加首页推荐品牌
     *
     * @param homeBrandList
     * @return
     */
    @RequestMapping(value = "home/brand/create", method = RequestMethod.POST)
    int create(@RequestBody List<HomeBrand> homeBrandList);

    /**
     * 修改品牌排序
     *
     * @param id
     * @param sort
     * @return
     */
    @RequestMapping(value = "home/brand/update/sort/{id}", method = RequestMethod.POST)
    int updateSort(@PathVariable Long id, Integer sort);

    /**
     * 批量删除推荐品牌
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "home/brand/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 批量修改推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    @RequestMapping(value = "home/brand/update/recommendStatus", method = RequestMethod.POST)
    int updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus);

    /**
     * 分页查询推荐品牌
     *
     * @param brandName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "home/brand/list", method = RequestMethod.GET)
    CommonPage<HomeBrand> list(@RequestParam(value = "brandName") String brandName,
                               @RequestParam(value = "recommendStatus") Integer recommendStatus,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "pageNum") Integer pageNum);
}
