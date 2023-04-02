package com.ccd.design_data.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.design_data.entity.OpmsDesignData;
import com.ccd.design_data.entity.vo.DesignDataQuery;
import com.ccd.design_data.service.OpmsDesignDataService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 设计资料表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-02-22
 */
@Api(tags = "光学零件管理-设计资料")
@RestController
@RequestMapping("/design_data/opms-design-data")
public class OpmsDesignDataController {

    @Autowired
    private OpmsDesignDataService designDataService;

    @ApiOperation("查询所有设计资料")
    @GetMapping("findAll")
    public R findAll() {
        return R.ok().data("items", designDataService.list(null));
    }

    @ApiOperation("逻辑删除设计资料")
    @DeleteMapping("{designDataId}")
    public R removeDesignData(@PathVariable Long designDataId) {
        return designDataService.removeById(designDataId) ? R.ok() : R.error();
    }

    @ApiOperation("分页查询设计资料")
    @GetMapping("pageDesignData/{current}/{limit}")
    public R pageListDesignData(@PathVariable Long current, @PathVariable Long limit) {
        //创建分页对象
        Page<OpmsDesignData> MyPage = new Page<>(current, limit);
        //调用方法实现分页
        designDataService.page(MyPage, null);
        return R.ok().data("page", MyPage);
    }

    @ApiOperation("条件查询设计资料带分页")
    @PostMapping("pageDesignDataCondition/{current}/{limit}")
    public R pageDesignDataCondition(@PathVariable Long current, @PathVariable Long limit,
                                     @RequestBody(required = false) DesignDataQuery query) {
        Page<OpmsDesignData> MyPage = new Page<>(current, limit);
        //构建条件
        QueryWrapper<OpmsDesignData> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String partsName = query.getPartsName();
        String createBy = query.getCreateBy();
        String begin = query.getBegin();
        String end = query.getEnd();
        if (!StringUtils.isEmpty(partsName)) {
            wrapper.eq("parts_name", partsName);
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
        //调用方法实现条件查询分页，并返回数据
        designDataService.page(MyPage, wrapper);
        return R.ok().data("page", MyPage);
    }

    @ApiOperation("新增设计资料")
    @PostMapping("addDesignData")
    public R addDesignData(@RequestBody OpmsDesignData designData) {
        return designDataService.save(designData) ? R.ok() : R.error();
    }

    @ApiOperation(value = "根据设计资料id进行查询")
    @GetMapping("getDesignDateById/{id}")
    public R getDesignDateById(@PathVariable String id) {
        return R.ok().data("DesignData",designDataService.getById(id));
    }

    @ApiOperation("修改设计资料")
    @PostMapping("updateDesignData")
    public R updateDesignData(@RequestBody OpmsDesignData designData) {
        return designDataService.updateById(designData)? R.ok(): R.error();
    }


}

