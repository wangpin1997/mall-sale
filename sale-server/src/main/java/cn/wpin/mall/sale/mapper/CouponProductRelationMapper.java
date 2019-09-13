package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.CouponProductRelation;
import cn.wpin.mall.sale.example.CouponProductRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponProductRelationMapper {

    long countByExample(CouponProductRelationExample example);

    int deleteByExample(CouponProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponProductRelation record);

    int insertSelective(CouponProductRelation record);

    List<CouponProductRelation> selectByExample(CouponProductRelationExample example);

    CouponProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponProductRelation record, @Param("example") CouponProductRelationExample example);

    int updateByExample(@Param("record") CouponProductRelation record, @Param("example") CouponProductRelationExample example);

    int updateByPrimaryKeySelective(CouponProductRelation record);

    int updateByPrimaryKey(CouponProductRelation record);
}