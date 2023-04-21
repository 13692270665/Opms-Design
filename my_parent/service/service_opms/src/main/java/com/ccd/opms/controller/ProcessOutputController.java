package com.ccd.opms.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.OpmsDesignData;
import com.ccd.opms.entity.ProcessOutput;
import com.ccd.opms.entity.vo.ProceOutputQuery;
import com.ccd.opms.service.ProcessOutputService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 工艺输出记录表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-15
 */
@CrossOrigin
@Api(tags = "工艺输出管理")
@RestController
@RequestMapping("/opms/process_output")
public class ProcessOutputController {

    @Autowired
    private ProcessOutputService processOutputService;

    @ApiOperation("查询工艺输出记录")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) ProceOutputQuery query){
        Page<ProcessOutput> page = new Page<>(current,limit);
        IPage<ProcessOutput> MyPage = processOutputService.findPage(page, query);
        return R.ok().data("rows",MyPage.getRecords()).data("total",MyPage.getTotal());
    }

    @ApiOperation("归档/提回")
    @PostMapping("updateStatus/{ids}/{status}")
    public R updateStatus(@PathVariable Collection<Integer> ids,@PathVariable String status) {
        for (Integer id : ids) {
            processOutputService.updateStatus(id,status);
        }
        return R.ok();
    }

    @ApiOperation("新增工艺输出记录")
    @PostMapping("add")
    public R add(@RequestBody ProcessOutput processOutput) {
        return processOutputService.save(processOutput) ? R.ok() : R.error();
    }

}

