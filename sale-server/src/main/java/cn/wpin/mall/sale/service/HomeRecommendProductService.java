package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.HomeRecommendProduct;
import cn.wpin.mall.sale.example.HomeRecommendProductExample;
import cn.wpin.mall.sale.mapper.HomeRecommendProductMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页人气推荐管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:28:37
 */
@Service
public class HomeRecommendProductService  {
    @Autowired
    private HomeRecommendProductMapper recommendProductMapper;

    public int create(List<HomeRecommendProduct> homeRecommendProductList) {
        for (HomeRecommendProduct recommendProduct : homeRecommendProductList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            recommendProductMapper.insert(recommendProduct);
        }
        return homeRecommendProductList.size();
    }

    public int updateSort(Long id, Integer sort) {
        HomeRecommendProduct recommendProduct = new HomeRecommendProduct();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    public int delete(List<Long> ids) {
        HomeRecommendProductExample example = new HomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeRecommendProductExample example = new HomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        HomeRecommendProduct record = new HomeRecommendProduct();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    public List<HomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        HomeRecommendProductExample example = new HomeRecommendProductExample();
        HomeRecommendProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }
}
