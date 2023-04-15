package com.ccd.opms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/15 12:35
 */
@Data
public class ProceOutputQuery {

    @ApiModelProperty(value = "计划号")
    private String planId;

    @ApiModelProperty(value = "零件名称")
    private String partsName;

    @ApiModelProperty(value = "状态（0代表输出中 1代表归档）")
    private String outputStatus;

}
