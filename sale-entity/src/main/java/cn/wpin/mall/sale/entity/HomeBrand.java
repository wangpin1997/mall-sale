package cn.wpin.mall.sale.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HomeBrand extends IdEntity {

    private Long brandId;

    private String brandName;

    private Integer recommendStatus;

    private Integer sort;

}