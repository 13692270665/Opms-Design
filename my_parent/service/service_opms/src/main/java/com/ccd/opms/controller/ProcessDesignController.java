package com.ccd.opms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.OpmsDesignData;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.vo.ProceDesignQuery;
import com.ccd.opms.service.OpmsDesignDataService;
import com.ccd.opms.service.ProcessDesignService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 工艺设计表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-13
 */
@CrossOrigin
@Api(tags = "光学零件管理-工艺设计")
@RestController
@RequestMapping("/opms/process_design")
public class ProcessDesignController {

    @Autowired
    ProcessDesignService processDesignService;
    @Autowired
    OpmsDesignDataService designDataService;

    @ApiOperation("查询工艺设计带分页")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                        @RequestBody(required = false) ProceDesignQuery query){
        Page<ProcessDesign> page = new Page<>(current,limit);
        IPage<ProcessDesign> MyPage = processDesignService.findPage(page, query);
        return R.ok().data("rows",MyPage.getRecords()).data("total",MyPage.getTotal());
    }

    @ApiOperation(value = "根据工艺设计id进行查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable String id) {
        ProcessDesign processDesign = processDesignService.getDetail(id);
        return R.ok().data("data",processDesign);
    }

    @ApiOperation("逻辑删除工艺设计")
    @DeleteMapping("del/{ids}")
    public R remove(@PathVariable Collection<Serializable> ids) {
        return processDesignService.removeByIds(ids) ? R.ok() : R.error();
    }

    @ApiOperation("新增工艺设计")
    @PostMapping("add")
    public R add(@RequestBody ProcessDesign processDesign) {
        return processDesignService.save(processDesign) ? R.ok() : R.error();
    }

    @ApiOperation("修改工艺设计")
    @PostMapping("update")
    public R update(@RequestBody ProcessDesign processDesign) {
        return processDesignService.updateById(processDesign)? R.ok(): R.error();
    }

}

