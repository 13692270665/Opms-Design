package com.ccd.opms.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/13 14:52
 */
@Data
public class ProceDesignQuery {

    @ApiModelProperty(value = "工艺设计ID")
    private String processDesignId;

    @ApiModelProperty(value = "零件名称")
    private String partsName;

    @ApiModelProperty(value = "零件类型")
    private String partsType;

    @ApiModelProperty(value = "透镜左面")
    private String lensLeft;

    @ApiModelProperty(value = "透镜右面")
    private String lensRight;

    @ApiModelProperty(value = "编制人")
    private String createBy;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "流程模板名称")
    private String templateName;

}
