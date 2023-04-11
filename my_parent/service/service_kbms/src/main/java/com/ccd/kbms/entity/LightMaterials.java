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
 * 可见光材料库
 * </p>
 *
 * @author CCD
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("kbms_light_materials")
@ApiModel(value="LightMaterials对象", description="可见光材料库")
public class LightMaterials implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "品牌")
    private Integer brand;

    @ApiModelProperty(value = "牌号")
    private String brandId;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "折射率")
    private String refractiveIndex;

    @ApiModelProperty(value = "色散系数")
    private String dispersionCoefficient;

    @ApiModelProperty(value = "密度")
    private String density;


}
