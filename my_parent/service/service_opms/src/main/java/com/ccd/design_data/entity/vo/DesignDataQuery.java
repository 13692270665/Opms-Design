package com.ccd.design_data.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ccd
 * @Date 2023/3/2 23:37
 */
@Data
public class DesignDataQuery {

    @ApiModelProperty(value = "零件名称")
    private String partsName;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
