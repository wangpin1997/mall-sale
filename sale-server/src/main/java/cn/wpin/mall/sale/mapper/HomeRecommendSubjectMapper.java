package cn.wpin.mall.sale.mapper;


import cn.wpin.mall.sale.entity.HomeRecommendSubject;
import cn.wpin.mall.sale.example.HomeRecommendSubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeRecommendSubjectMapper {

    long countByExample(HomeRecommendSubjectExample example);

    int deleteByExample(HomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeRecommendSubject record);

    int insertSelective(HomeRecommendSubject record);

    List<HomeRecommendSubject> selectByExample(HomeRecommendSubjectExample example);

    HomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeRecommendSubject record, @Param("example") HomeRecommendSubjectExample example);

    int updateByExample(@Param("record") HomeRecommendSubject record, @Param("example") HomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(HomeRecommendSubject record);

    int updateByPrimaryKey(HomeRecommendSubject record);
}