package com.ccd.temp.entity.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/11 22:13
 */
@Data
public class ProceTempQuery {

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "模板类型")
    private String templateType;

    @ApiModelProperty(value = "创建人")
    private String createBy;

}
