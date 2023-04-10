package com.ccd.kbms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :ccd
 * @date : 2023/4/10 19:45
 */
@Data
public class pLQuery {

    @ApiModelProperty(value = "工序名称")
    private String processName;

}
