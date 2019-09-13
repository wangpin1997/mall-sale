package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.CouponHistory;
import cn.wpin.mall.sale.example.CouponHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponHistoryMapper {

    long countByExample(CouponHistoryExample example);

    int deleteByExample(CouponHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponHistory record);

    int insertSelective(CouponHistory record);

    List<CouponHistory> selectByExample(CouponHistoryExample example);

    CouponHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponHistory record, @Param("example") CouponHistoryExample example);

    int updateByExample(@Param("record") CouponHistory record, @Param("example") CouponHistoryExample example);

    int updateByPrimaryKeySelective(CouponHistory record);

    int updateByPrimaryKey(CouponHistory record);
}