package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.HomeNewProduct;
import cn.wpin.mall.sale.example.HomeNewProductExample;
import cn.wpin.mall.sale.mapper.HomeNewProductMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页新品推荐管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:27:53
 */
@Service
public class HomeNewProductService{
    @Autowired
    private HomeNewProductMapper homeNewProductMapper;

    public int create(List<HomeNewProduct> homeNewProductList) {
        for (HomeNewProduct HomeNewProduct : homeNewProductList) {
            HomeNewProduct.setRecommendStatus(1);
            HomeNewProduct.setSort(0);
            homeNewProductMapper.insert(HomeNewProduct);
        }
        return homeNewProductList.size();
    }

    public int updateSort(Long id, Integer sort) {
        HomeNewProduct homeNewProduct = new HomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return homeNewProductMapper.updateByPrimaryKeySelective(homeNewProduct);
    }

    public int delete(List<Long> ids) {
        HomeNewProductExample example = new HomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        return homeNewProductMapper.deleteByExample(example);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeNewProductExample example = new HomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        HomeNewProduct record = new HomeNewProduct();
        record.setRecommendStatus(recommendStatus);
        return homeNewProductMapper.updateByExampleSelective(record,example);
    }

    public List<HomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        HomeNewProductExample example = new HomeNewProductExample();
        HomeNewProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeNewProductMapper.selectByExample(example);
    }
}
