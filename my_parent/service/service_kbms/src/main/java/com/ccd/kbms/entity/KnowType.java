package com.ccd.kbms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 栏目信息表
 * </p>
 *
 * @author CCD
 * @since 2023-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("kbms_know_type")
@ApiModel(value="KnowType对象", description="栏目信息表")
public class KnowType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栏目ID")
    @TableId(value = "type_id", type = IdType.AUTO)
    private Long typeId;

    @ApiModelProperty(value = "栏目名称")
    private String typeTitle;

    @ApiModelProperty(value = "顺序")
    private Integer orderNum;


}
