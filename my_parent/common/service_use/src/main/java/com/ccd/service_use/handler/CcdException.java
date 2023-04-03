package com.ccd.service_use.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :ccd
 * @date : 2023/4/3 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CcdException extends RuntimeException  {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;
}
