package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeNewProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface HomeNewProductClient {

    /**
     * 添加首页推荐品牌
     *
     * @param homeBrandList
     * @return
     */
    @RequestMapping(value = "home/newProduct/create", method = RequestMethod.POST)
    int create(@RequestBody List<HomeNewProduct> homeBrandList);

    /**
     * 修改推荐排序
     *
     * @param id
     * @param sort
     * @return
     */
    @RequestMapping(value = "home/newProduct/update/sort/{id}", method = RequestMethod.POST)
    int updateSort(@PathVariable Long id, Integer sort);

    /**
     * 批量删除推荐
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "home/newProduct/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 批量修改推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    @RequestMapping(value = "home/newProduct/update/recommendStatus", method = RequestMethod.POST)
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
    @RequestMapping(value = "home/newProduct/list", method = RequestMethod.GET)
    CommonPage<HomeNewProduct> list(@RequestParam(value = "productName") String productName,
                                    @RequestParam(value = "recommendStatus") Integer recommendStatus,
                                    @RequestParam(value = "pageSize") Integer pageSize,
                                    @RequestParam(value = "pageNum") Integer pageNum);
}
