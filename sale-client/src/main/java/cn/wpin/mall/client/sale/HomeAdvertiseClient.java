package cn.wpin.mall.client.sale;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeAdvertise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("sale")
public interface HomeAdvertiseClient {

    /**
     * 添加广告
     *
     * @param advertise
     * @return
     */
    @RequestMapping(value = "home/advertise/create", method = RequestMethod.POST)
    int create(@RequestBody HomeAdvertise advertise);

    /**
     * 删除广告
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "home/advertise/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 修改上下线状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "home/advertise/update/status/{id}", method = RequestMethod.POST)
    int updateStatus(@PathVariable Long id, Integer status);

    /**
     * 获取广告详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "home/advertise/{id}", method = RequestMethod.GET)
    HomeAdvertise getItem(@PathVariable Long id);

    /**
     * 修改广告
     *
     * @param id
     * @param advertise
     * @return
     */
    @RequestMapping(value = "home/advertise/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody HomeAdvertise advertise);

    /**
     * 分页查询广告
     *
     * @param name
     * @param type
     * @param endTime
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "home/advertise/list", method = RequestMethod.GET)
    CommonPage<HomeAdvertise> list(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "type") Integer type,
                                   @RequestParam(value = "endTime") String endTime,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "pageNum") Integer pageNum);


    /**
     * 修改广告
     *
     * @return List<HomeAdvertise>
     */
    @RequestMapping(value = "home/advertise/getHomeAdvertiseList", method = RequestMethod.POST)
    List<HomeAdvertise> getHomeAdvertiseList();
}
