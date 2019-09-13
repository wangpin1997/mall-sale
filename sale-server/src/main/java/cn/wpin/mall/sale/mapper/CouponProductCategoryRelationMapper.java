package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.CouponProductCategoryRelation;
import cn.wpin.mall.sale.example.CouponProductCategoryRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponProductCategoryRelationMapper {
    long countByExample(CouponProductCategoryRelationExample example);

    int deleteByExample(CouponProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponProductCategoryRelation record);

    int insertSelective(CouponProductCategoryRelation record);

    List<CouponProductCategoryRelation> selectByExample(CouponProductCategoryRelationExample example);

    CouponProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponProductCategoryRelation record, @Param("example") CouponProductCategoryRelationExample example);

    int updateByExample(@Param("record") CouponProductCategoryRelation record, @Param("example") CouponProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(CouponProductCategoryRelation record);

    int updateByPrimaryKey(CouponProductCategoryRelation record);
}