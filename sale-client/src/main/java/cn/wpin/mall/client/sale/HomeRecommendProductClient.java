package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface HomeRecommendProductClient {

    /**
     * 添加首页推荐
     *
     * @param homeBrandList
     * @return
     */
    @RequestMapping(value = "home/recommendProduct/create", method = RequestMethod.POST)
    int create(@RequestBody List<HomeRecommendProduct> homeBrandList);

    /**
     * 修改推荐排序
     *
     * @param id
     * @param sort
     * @return
     */
    @RequestMapping(value = "home/recommendProduct/update/sort/{id}", method = RequestMethod.POST)
    int updateSort(@PathVariable Long id,@RequestParam Integer sort);

    /**
     * 批量删除推荐
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "home/recommendProduct/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 批量修改推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    @RequestMapping(value = "home/recommendProduct/update/recommendStatus", method = RequestMethod.POST)
    int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                              @RequestParam Integer recommendStatus);

    /**
     * 分页查询推荐
     *
     * @param productName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "home/recommendProduct/list", method = RequestMethod.GET)
    CommonPage<HomeRecommendProduct> list(@RequestParam(value = "productName") String productName,
                                          @RequestParam(value = "recommendStatus") Integer recommendStatus,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "pageNum") Integer pageNum);
}
