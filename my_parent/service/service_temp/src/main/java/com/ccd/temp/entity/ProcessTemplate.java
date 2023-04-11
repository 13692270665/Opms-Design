package com.ccd.temp.entity;

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
 * 工艺流程模板表
 * </p>
 *
 * @author CCD
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("temp_process_template")
@ApiModel(value="ProcessTemplate对象", description="工艺流程模板表")
public class ProcessTemplate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号id")
    @TableId(value = "process_template_id", type = IdType.AUTO)
    private Long processTemplateId;

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "模板类型")
    private String templateType;

    @ApiModelProperty(value = "加工步骤")
    private String processingSteps;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "备注")
    private String remark;


}
