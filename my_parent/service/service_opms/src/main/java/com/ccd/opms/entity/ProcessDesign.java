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

    // 额外属性

    @ApiModelProperty(value = "产品代号")
    private String productId;

    @ApiModelProperty(value = "零件编号")
    private String partsId;

    @ApiModelProperty(value = "流程模板名称")
    private String templateName;

    @ApiModelProperty(value = "透镜左面")
    private String lensLeft;

    @ApiModelProperty(value = "透镜右面")
    private String lensRight;

    @ApiModelProperty(value = "零件类型")
    private String partsType;

    @ApiModelProperty(value = "零件名称")
    private String partsName;

    @ApiModelProperty(value = "材料牌号")
    private String materialMark;

    @ApiModelProperty(value = "材料标准")
    private String materialStandard;

    @ApiModelProperty(value = "备注")
    private String remark;

}
