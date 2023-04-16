package com.ccd.kbms.entity;

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
 * 内容信息表
 * </p>
 *
 * @author CCD
 * @since 2023-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("kbms_know_content")
@ApiModel(value="KnowContent对象", description="内容信息表")
public class KnowContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内容ID")
    @TableId(value = "content_id", type = IdType.AUTO)
    private Long contentId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "所属栏目")
    private Long typeId;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "内容")
    private String contentInfo;

    @ApiModelProperty(value = "状态（0.发布 1.草稿， 2.待评审， 3.通过， 4.失败）")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "评审人")
    private String auditBy;

    @ApiModelProperty(value = "评审时间")
    @TableField(fill = FieldFill.INSERT)
    private Date auditTime;


}
