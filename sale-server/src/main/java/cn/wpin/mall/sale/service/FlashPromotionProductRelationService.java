package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.dao.FlashPromotionProductRelationDao;
import cn.wpin.mall.sale.dto.FlashPromotionProduct;
import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import cn.wpin.mall.sale.example.FlashPromotionProductRelationExample;
import cn.wpin.mall.sale.mapper.FlashPromotionProductRelationMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 限时购商品关联管理Service实现类
 * @author wangpin
 */
@Service
public class FlashPromotionProductRelationService {
    @Autowired
    private FlashPromotionProductRelationMapper relationMapper;
    @Autowired
    private FlashPromotionProductRelationDao relationDao;

    public int create(List<FlashPromotionProductRelation> relationList) {
        for (FlashPromotionProductRelation relation : relationList) {
            relationMapper.insert(relation);
        }
        return relationList.size();
    }

    public int update(Long id, FlashPromotionProductRelation relation) {
        relation.setId(id);
        return relationMapper.updateByPrimaryKey(relation);
    }

    public int delete(Long id) {
        return relationMapper.deleteByPrimaryKey(id);
    }

    public FlashPromotionProductRelation getItem(Long id) {
        return relationMapper.selectByPrimaryKey(id);
    }

    public List<FlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return relationDao.getList(flashPromotionId,flashPromotionSessionId);
    }

    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        FlashPromotionProductRelationExample example = new FlashPromotionProductRelationExample();
        example.createCriteria()
                .andFlashPromotionIdEqualTo(flashPromotionId)
                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        return relationMapper.countByExample(example);
    }
}
