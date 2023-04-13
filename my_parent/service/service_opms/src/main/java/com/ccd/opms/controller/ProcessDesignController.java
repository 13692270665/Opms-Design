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
                                     @RequestBody(required = false) ProceDesignQuery query) {
        Page<ProcessDesign> MyPage = new Page<>(current, limit);
        QueryWrapper<OpmsDesignData> ddWrapper = new QueryWrapper<>();
        String partsType = query.getPartsType();
        String partsName = query.getPartsName();
        String lensLeft = query.getLensLeft();
        String lensRight = query.getLensRight();
        if (!StringUtils.isEmpty(partsType)) {
            ddWrapper.eq("parts_type", partsType);
        }
        if (!StringUtils.isEmpty(partsName)) {
            ddWrapper.eq("parts_name", partsName);
        }
        if (!StringUtils.isEmpty(lensLeft)) {
            ddWrapper.eq("lens_left", lensLeft);
        }
        if (!StringUtils.isEmpty(lensRight)) {
            ddWrapper.eq("lens_right", lensRight);
        }
        List<OpmsDesignData> ddid = designDataService.list(ddWrapper.select("design_data_id"));
        Collection<Serializable> ids = new ArrayList<>();
        for (OpmsDesignData opmsDesignData : ddid) {
            ids.add(opmsDesignData.getDesignDataId());
        }
        QueryWrapper<ProcessDesign> wrapper = new QueryWrapper<>();
        String status = query.getStatus();
        String createBy = query.getCreateBy();
        String begin = query.getBegin();
        String end = query.getEnd();
        if (!StringUtils.isEmpty(status)) {
            wrapper.eq("status", status);
        }
        if (!StringUtils.isEmpty(createBy)) {
            wrapper.eq("create_by", createBy);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("create_time", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("create_time", end);
        }
        if(!ddid.isEmpty()){
            wrapper.in("design_data_id",ids);
        }
        wrapper.orderByDesc("create_time");
        processDesignService.page(MyPage, wrapper);
        return R.ok().data("total",MyPage.getTotal()).data("rows",MyPage.getRecords());
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

    @ApiOperation(value = "根据工艺设计id进行查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("data",processDesignService.getById(id));
    }

    @ApiOperation("修改工艺设计")
    @PostMapping("update")
    public R update(@RequestBody ProcessDesign processDesign) {
        return processDesignService.updateById(processDesign)? R.ok(): R.error();
    }

}

