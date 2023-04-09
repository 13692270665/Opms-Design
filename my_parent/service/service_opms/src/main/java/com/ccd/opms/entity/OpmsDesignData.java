package com.ccd.opms.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import com.ccd.service_use.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设计资料表
 * </p>
 *
 * @author CCD
 * @since 2023-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OpmsDesignData对象", description="设计资料表")
public class OpmsDesignData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设计资料ID")
    @TableId(value = "design_data_id", type = IdType.AUTO)
    private Long designDataId;

    @ApiModelProperty(value = "模板编号")
    private Long templateId;

    @ApiModelProperty(value = "产品代号")
    private String productId;

    @ApiModelProperty(value = "零件编号")
    private String partsId;

    @ApiModelProperty(value = "零件类型")
    private String partsType;

    @ApiModelProperty(value = "零件名称")
    private String partsName;

    @ApiModelProperty(value = "所属装配号")
    private String assemblyNumber;

    @ApiModelProperty(value = "材料折射率")
    private String materialRefractive;

    @ApiModelProperty(value = "材料牌号")
    private String materialMark;

    @ApiModelProperty(value = "材料标准")
    private String materialStandard;

    @ApiModelProperty(value = "比例")
    private String ratio;

    @ApiModelProperty(value = "重量")
    private String weight;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "透镜左面")
    private String lensLeft;

    @ApiModelProperty(value = "透镜右面")
    private String lensRight;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    @TableLogic
    private Boolean delFlag;

}
