package com.ccd.temp.controller;

import com.ccd.temp.service.DictDataService;
import com.ccd.temp.service.DictTypeService;
import com.ccd.temp.service.ProcessTemplateService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :ccd
 * @date : 2023/4/17 11:29
 */
@CrossOrigin
@Api(tags = "模板配置管理-统计")
@RestController
@RequestMapping("/temp/count")
public class StatisticsController {

    @Autowired
    DictDataService dictDataService;
    @Autowired
    DictTypeService dictTypeService;
    @Autowired
    ProcessTemplateService processTemplateService;

    @ApiOperation("查询数据统计")
    @PostMapping("count")
    public Map<String,Integer> getTempCount(){
        Map<String,Integer> map = new HashMap<>();
        map.put("dictData",dictDataService.count(null));
        map.put("dictType",dictTypeService.count(null));
        map.put("processTemplates",processTemplateService.count(null));
        return map;
    }

}
