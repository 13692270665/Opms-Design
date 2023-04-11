package com.ccd.kbms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/11 14:10
 */
@Data
public class lMQuery {

    @ApiModelProperty(value = "品牌")
    private Integer brand;

    @ApiModelProperty(value = "牌号")
    private String brandId;

    @ApiModelProperty(value = "编码")
    private String code;

}
