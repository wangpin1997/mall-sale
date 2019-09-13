package cn.wpin.mall.sale.mapper;

import cn.wpin.mall.sale.entity.HomeAdvertise;
import cn.wpin.mall.sale.example.HomeAdvertiseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeAdvertiseMapper {

    long countByExample(HomeAdvertiseExample example);

    int deleteByExample(HomeAdvertiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeAdvertise record);

    int insertSelective(HomeAdvertise record);

    List<HomeAdvertise> selectByExample(HomeAdvertiseExample example);

    HomeAdvertise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeAdvertise record, @Param("example") HomeAdvertiseExample example);

    int updateByExample(@Param("record") HomeAdvertise record, @Param("example") HomeAdvertiseExample example);

    int updateByPrimaryKeySelective(HomeAdvertise record);

    int updateByPrimaryKey(HomeAdvertise record);
}