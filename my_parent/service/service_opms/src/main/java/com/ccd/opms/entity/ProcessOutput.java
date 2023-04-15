package com.ccd.opms.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工艺输出记录表
 * </p>
 *
 * @author CCD
 * @since 2023-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("opms_process_output")
@ApiModel(value="ProcessOutput对象", description="工艺输出记录表")
public class ProcessOutput implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工艺输出记录ID")
    @TableId(value = "process_output_record_id", type = IdType.AUTO)
    private Long processOutputRecordId;

    @ApiModelProperty(value = "工艺设计编号")
    private String processDesignId;

    @ApiModelProperty(value = "计划号")
    private String planId;

    @ApiModelProperty(value = "生产数量")
    private Integer count;

    @ApiModelProperty(value = "输出人")
    private String outputBy;

    @ApiModelProperty(value = "输出时间")
    @TableField(fill = FieldFill.INSERT)
    private Date outputTime;

    @ApiModelProperty(value = "状态（0代表输出中 1代表归档）")
    private String outputStatus;


}
