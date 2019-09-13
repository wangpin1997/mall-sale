package cn.wpin.mall.sale.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HomeRecommendSubject extends IdEntity {

    private Long subjectId;

    private String subjectName;

    private Integer recommendStatus;

    private Integer sort;

}