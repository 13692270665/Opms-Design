package com.ccd.opms.controller;

import com.ccd.opms.client.KbsClient;
import com.ccd.opms.client.TempClient;
import com.ccd.opms.service.OpmsDesignDataService;
import com.ccd.opms.service.ProcessDesignService;
import com.ccd.opms.service.ProcessOutputService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :ccd
 * @date : 2023/4/17 10:44
 */
@CrossOrigin
@Api(tags = "首页数据统计")
@RestController
@RequestMapping("/opms/statistics")
public class StatisticsController {

    @Autowired
    OpmsDesignDataService opmsDesignDataService;
    @Autowired
    ProcessDesignService processDesignService;
    @Autowired
    ProcessOutputService processOutputService;
    @Autowired
    TempClient tempClient;
    @Autowired
    KbsClient kbsClient;

    @ApiOperation("查询首页数据统计")
    @PostMapping("getInfo")
    public R list(){
        Map<String,Integer> map = new HashMap<>();
        map.put("designData", opmsDesignDataService.count(null));
        map.put("processDesigns", processDesignService.count(null));
        map.put("outputRecords", processOutputService.count(null));

        Map<String, Integer> tempCount = tempClient.getTempCount();
        map.put("processTemplates", tempCount.get("processTemplates"));
        map.put("dictData", tempCount.get("dictData"));
        map.put("dictType", tempCount.get("dictType"));

        Map<String, Integer> kbsCount = kbsClient.getKbsCount();
        map.put("knowContent", kbsCount.get("knowContent"));
        map.put("lightMater", kbsCount.get("lightMater"));
        map.put("processLibrary", kbsCount.get("processLibrary"));

        return R.ok().data("map",map);
    }

}
