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
 * 工艺设计审核表
 * </p>
 *
 * @author CCD
 * @since 2023-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("opms_process_design_audit")
@ApiModel(value="ProcessDesignAudit对象", description="工艺设计审核表")
public class ProcessDesignAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "audit_id", type = IdType.AUTO)
    private Long auditId;

    @ApiModelProperty(value = "工艺设计编号")
    private String processDesignId;

    @ApiModelProperty(value = "审核人姓名")
    private String auditUserName;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "意见")
    private String description;


}
