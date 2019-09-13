package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.HomeRecommendSubject;
import cn.wpin.mall.sale.example.HomeRecommendSubjectExample;
import cn.wpin.mall.sale.mapper.HomeRecommendSubjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页专题推荐管理Service实现类
 * @author wangpin 
 */
@Service
public class HomeRecommendSubjectService {

    @Autowired
    private HomeRecommendSubjectMapper recommendProductMapper;

    public int create(List<HomeRecommendSubject> recommendSubjectList) {
        for (HomeRecommendSubject recommendProduct : recommendSubjectList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            recommendProductMapper.insert(recommendProduct);
        }
        return recommendSubjectList.size();
    }

    public int updateSort(Long id, Integer sort) {
        HomeRecommendSubject recommendProduct = new HomeRecommendSubject();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    public int delete(List<Long> ids) {
        HomeRecommendSubjectExample example = new HomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeRecommendSubjectExample example = new HomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        HomeRecommendSubject record = new HomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    public List<HomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        HomeRecommendSubjectExample example = new HomeRecommendSubjectExample();
        HomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(subjectName)){
            criteria.andSubjectNameLike("%"+subjectName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }
}
