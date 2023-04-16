package com.ccd.kbms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/16 17:54
 */
@Data
public class KnowContentQuery {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "所属栏目")
    private Long typeId;

    @ApiModelProperty(value = "作者")
    private String author;

}
