package cn.wpin.mall.sale.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HomeNewProduct extends IdEntity {

    private Long productId;

    private String productName;

    private Integer recommendStatus;

    private Integer sort;

}