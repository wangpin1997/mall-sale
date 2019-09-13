package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.HomeBrand;
import cn.wpin.mall.sale.example.HomeBrandExample;
import cn.wpin.mall.sale.mapper.HomeBrandMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页品牌管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:27:09
 */
@Service
public class HomeBrandService {
    @Autowired
    private HomeBrandMapper homeBrandMapper;

    public int create(List<HomeBrand> homeBrandList) {
        for (HomeBrand smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
            homeBrandMapper.insert(smsHomeBrand);
        }
        return homeBrandList.size();
    }

    public int updateSort(Long id, Integer sort) {
        HomeBrand homeBrand = new HomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

    public int delete(List<Long> ids) {
        HomeBrandExample example = new HomeBrandExample();
        example.createCriteria().andIdIn(ids);
        return homeBrandMapper.deleteByExample(example);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeBrandExample example = new HomeBrandExample();
        example.createCriteria().andIdIn(ids);
        HomeBrand record = new HomeBrand();
        record.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(record,example);
    }

    public List<HomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        HomeBrandExample example = new HomeBrandExample();
        HomeBrandExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(brandName)){
            criteria.andBrandNameLike("%"+brandName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeBrandMapper.selectByExample(example);
    }
}
