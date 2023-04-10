package com.ccd.kbms.entity;

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
 * 工序表
 * </p>
 *
 * @author CCD
 * @since 2023-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("kbms_process_library")
@ApiModel(value="ProcessLibrary对象", description="工序表")
public class ProcessLibrary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工序Id")
    @TableId(value = "serial_id", type = IdType.AUTO)
    private Long serialId;

    @ApiModelProperty(value = "工序名称")
    private String processName;

    @ApiModelProperty(value = "加工参数")
    private String processParams;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    private String delFlag;


}
