package cn.wpin.mall.sale.service;

import cn.wpin.mall.sale.dao.CouponDao;
import cn.wpin.mall.sale.dao.CouponProductCategoryRelationDao;
import cn.wpin.mall.sale.dao.CouponProductRelationDao;
import cn.wpin.mall.sale.dto.CouponParam;
import cn.wpin.mall.sale.entity.Coupon;
import cn.wpin.mall.sale.entity.CouponProductCategoryRelation;
import cn.wpin.mall.sale.entity.CouponProductRelation;
import cn.wpin.mall.sale.example.CouponExample;
import cn.wpin.mall.sale.example.CouponProductCategoryRelationExample;
import cn.wpin.mall.sale.example.CouponProductRelationExample;
import cn.wpin.mall.sale.mapper.CouponMapper;
import cn.wpin.mall.sale.mapper.CouponProductCategoryRelationMapper;
import cn.wpin.mall.sale.mapper.CouponProductRelationMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 优惠券管理Service实现类
 * @author wangpin
 */
@Service
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponProductRelationMapper productRelationMapper;
    @Autowired
    private CouponProductCategoryRelationMapper productCategoryRelationMapper;
    @Autowired
    private CouponProductRelationDao productRelationDao;
    @Autowired
    private CouponProductCategoryRelationDao productCategoryRelationDao;
    @Autowired
    private CouponDao couponDao;


    public int create(CouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠券表
        int count = couponMapper.insert(couponParam);
        //插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(CouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            productRelationDao.insertList(couponParam.getProductRelationList());
        }
        //插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (CouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            productCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    public int delete(Long id) {
        //删除优惠券
        int count = couponMapper.deleteByPrimaryKey(id);
        //删除商品关联
        deleteProductRelation(id);
        //删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    private void deleteProductCategoryRelation(Long id) {
        CouponProductCategoryRelationExample productCategoryRelationExample = new CouponProductCategoryRelationExample();
        productCategoryRelationExample.createCriteria().andCouponIdEqualTo(id);
        productCategoryRelationMapper.deleteByExample(productCategoryRelationExample);
    }

    private void deleteProductRelation(Long id) {
        CouponProductRelationExample productRelationExample = new CouponProductRelationExample();
        productRelationExample.createCriteria().andCouponIdEqualTo(id);
        productRelationMapper.deleteByExample(productRelationExample);
    }

    public int update(Long id, CouponParam couponParam) {
        couponParam.setId(id);
        int count =couponMapper.updateByPrimaryKey(couponParam);
        //删除后插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(CouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            productRelationDao.insertList(couponParam.getProductRelationList());
        }
        //删除后插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (CouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            productCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    public List<Coupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        CouponExample example = new CouponExample();
        CouponExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if(type!=null){
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    public CouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }
}
