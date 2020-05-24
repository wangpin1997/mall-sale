package cn.wpin.mall.sale.entity;

import cn.wpin.mall.common.entity.IdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * oms_cart_item
 * @author wangpin 2019-09-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("oms_cart_item")
public class CartItem extends IdEntity {


    @ApiModelProperty("product_id")
    private Long productId;

    @ApiModelProperty("product_sku_id")
    private Long productSkuId;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("购买数量")
    private Integer quantity;

    @ApiModelProperty("添加到购物车的价格")
    private BigDecimal price;

    @ApiModelProperty("销售属性1")
    private String sp1;

    @ApiModelProperty("销售属性2")
    private String sp2;

    @ApiModelProperty("销售属性3")
    private String sp3;

    @ApiModelProperty("商品主图")
    private String productPic;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商品副标题（卖点）")
    private String productSubTitle;

    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    @ApiModelProperty("会员昵称")
    private String memberNickname;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("修改时间")
    private Date modifyDate;

    @ApiModelProperty("是否删除")
    private Integer deleteStatus;

    @ApiModelProperty("商品分类")
    private Long productCategoryId;

    @ApiModelProperty("product_brand")
    private String productBrand;

    @ApiModelProperty("product_sn")
    private String productSn;

    @ApiModelProperty("商品销售属性:[{ key : 颜色 ， value : 颜色 }，{ key : 容量 ， value : 4g }]")
    private String productAttr;

}