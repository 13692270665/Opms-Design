package com.ccd.kbms.controller;

import com.ccd.kbms.service.KnowContentService;
import com.ccd.kbms.service.LightMaterialsService;
import com.ccd.kbms.service.ProcessLibraryService;
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
 * @date : 2023/4/17 13:28
 */
@CrossOrigin
@Api(tags = "知识库管理-统计")
@RestController
@RequestMapping("/kbms/count")
public class StatisticsController {

    @Autowired
    KnowContentService knowContentService;
    @Autowired
    LightMaterialsService lightMaterialsService;
    @Autowired
    ProcessLibraryService processLibraryService;

    @ApiOperation("查询数据统计")
    @PostMapping("count")
    public Map<String,Integer> getKbsCount(){
        Map<String,Integer> map = new HashMap<>();
        map.put("knowContent",knowContentService.count(null));
        map.put("lightMater",lightMaterialsService.count(null));
        map.put("processLibrary",processLibraryService.count(null));
        return map;
    }

}
