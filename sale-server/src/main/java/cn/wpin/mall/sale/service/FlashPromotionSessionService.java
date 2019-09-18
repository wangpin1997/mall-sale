package cn.wpin.mall.sale.service;


import cn.wpin.mall.sale.dto.FlashPromotionSessionDetail;
import cn.wpin.mall.sale.entity.FlashPromotionSession;
import cn.wpin.mall.sale.example.FlashPromotionSessionExample;
import cn.wpin.mall.sale.mapper.FlashPromotionSessionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 限时购场次管理Service实现类
 * @author wangpin
 */
@Service
public class FlashPromotionSessionService {
    @Autowired
    private FlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private FlashPromotionProductRelationService relationService;

    public int create(FlashPromotionSession promotionSession) {
        promotionSession.setCreateTime(new Date());
        return promotionSessionMapper.insert(promotionSession);
    }

    public int update(Long id, FlashPromotionSession promotionSession) {
        promotionSession.setId(id);
        return promotionSessionMapper.updateByPrimaryKey(promotionSession);
    }

    public int updateStatus(Long id, Integer status) {
        FlashPromotionSession promotionSession = new FlashPromotionSession();
        promotionSession.setId(id);
        promotionSession.setStatus(status);
        return promotionSessionMapper.updateByPrimaryKeySelective(promotionSession);
    }

    public int delete(Long id) {
        return promotionSessionMapper.deleteByPrimaryKey(id);
    }

    public FlashPromotionSession getItem(Long id) {
        return promotionSessionMapper.selectByPrimaryKey(id);
    }

    public List<FlashPromotionSession> list() {
        FlashPromotionSessionExample example = new FlashPromotionSessionExample();
        return promotionSessionMapper.selectByExample(example);
    }

    public List<FlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<FlashPromotionSessionDetail> result = new ArrayList<>();
        FlashPromotionSessionExample example = new FlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<FlashPromotionSession> list = promotionSessionMapper.selectByExample(example);
        for (FlashPromotionSession promotionSession : list) {
            FlashPromotionSessionDetail detail = new FlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            long count = relationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return result;
    }

    public FlashPromotionSession getNextFlashPromotionSession(Date date) {
        FlashPromotionSessionExample sessionExample = new FlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(date);
        sessionExample.setOrderByClause("start_time asc");
        List<FlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

}
