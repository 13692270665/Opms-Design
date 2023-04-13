package com.ccd.opms.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.ccd.service_use.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工艺设计表
 * </p>
 *
 * @author CCD
 * @since 2023-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("opms_process_design")
@ApiModel(value="ProcessDesign对象", description="工艺设计表")
public class ProcessDesign extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工艺设计ID")
    @TableId(value = "process_design_id", type = IdType.ID_WORKER_STR)
    private String processDesignId;

    @ApiModelProperty(value = "设计资料模板编号")
    private Long designDataTemplateId;

    @ApiModelProperty(value = "设计资料编号")
    private Long designDataId;

    @ApiModelProperty(value = "流程模板编")
    private Long processTemplateId;

    @ApiModelProperty(value = "毛坯尺寸")
    private String blankSize;

    @ApiModelProperty(value = "对样板编号")
    private Long modelId;

    @ApiModelProperty(value = "样板直径")
    private String modelDiameter;

    @ApiModelProperty(value = "样板数量")
    private String modelNumber;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "编制人")
    private String createBy;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    @TableLogic
    private String delFlag;

    private String planId;


}
