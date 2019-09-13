package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.FlashPromotion;
import cn.wpin.mall.sale.example.FlashPromotionExample;
import cn.wpin.mall.sale.mapper.FlashPromotionMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 限时购活动管理Service实现类
 * @author wangpin 
 */
@Service
public class FlashPromotionService {
    @Autowired
    private FlashPromotionMapper flashPromotionMapper;

    public int create(FlashPromotion flashPromotion) {
        flashPromotion.setCreateTime(new Date());
        return flashPromotionMapper.insert(flashPromotion);
    }

    public int update(Long id, FlashPromotion flashPromotion) {
        flashPromotion.setId(id);
        return flashPromotionMapper.updateByPrimaryKey(flashPromotion);
    }

    public int delete(Long id) {
        return flashPromotionMapper.deleteByPrimaryKey(id);
    }

    public int updateStatus(Long id, Integer status) {
        FlashPromotion flashPromotion = new FlashPromotion();
        flashPromotion.setId(id);
        flashPromotion.setStatus(status);
        return flashPromotionMapper.updateByPrimaryKeySelective(flashPromotion);
    }

    public FlashPromotion getItem(Long id) {
        return flashPromotionMapper.selectByPrimaryKey(id);
    }

    public List<FlashPromotion> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FlashPromotionExample example = new FlashPromotionExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andTitleLike("%" + keyword + "%");
        }
        return flashPromotionMapper.selectByExample(example);
    }
}
