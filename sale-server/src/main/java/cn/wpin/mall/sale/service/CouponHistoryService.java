package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.entity.CouponHistory;
import cn.wpin.mall.sale.example.CouponHistoryExample;
import cn.wpin.mall.sale.mapper.CouponHistoryMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 优惠券领取记录管理Service实现类
 *
 * @author wangpin
 */
@Service
public class CouponHistoryService {
    @Autowired
    private CouponHistoryMapper historyMapper;

    public List<CouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        CouponHistoryExample example = new CouponHistoryExample();
        CouponHistoryExample.Criteria criteria = example.createCriteria();
        if (couponId != null) {
            criteria.andCouponIdEqualTo(couponId);
        }
        if (useStatus != null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        return historyMapper.selectByExample(example);
    }

    public void updateCouponStatus(Long couponId, Long memberId, Integer useStatus) {
        if (couponId == null) {
            return;
        }
        //查询第一张优惠券
        CouponHistoryExample example = new CouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus == 0 ? 1 : 0);
        List<CouponHistory> couponHistoryList = historyMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(couponHistoryList)) {
            CouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            historyMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }
}
