package com.ccd.temp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.temp.entity.DictType;
import com.ccd.temp.entity.Vo.TempQuery;
import com.ccd.temp.service.DictTypeService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-09
 */
@CrossOrigin
@Api(tags = "模板配置管理-字典管理")
@RestController
@RequestMapping("/temp/dict_type")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    @ApiOperation("条件查询字典类型带分页")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) TempQuery query) {
        Page<DictType> MyPage = new Page<>(current, limit);
        //构建条件
        QueryWrapper<DictType> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String dictName = query.getDictName();
        String dictType = query.getDictType();
        String begin = query.getBegin();
        String end = query.getEnd();
        if (!StringUtils.isEmpty(dictName)) {
            wrapper.eq("dict_name", dictName);
        }
        if (!StringUtils.isEmpty(dictType)) {
            wrapper.eq("dict_type", dictType);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("create_time", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("create_time", end);
        }
        //调用方法实现条件查询分页，并返回数据
        dictTypeService.page(MyPage, wrapper);
        List<DictType> records = MyPage.getRecords();
        long total = MyPage.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("删除字典类型")
    @DeleteMapping("delete/{dictTypeId}")
    public R remove(@PathVariable Collection<Serializable> dictTypeId) {
        return dictTypeService.removeByIds(dictTypeId) ? R.ok() : R.error();
    }

    @ApiOperation("新增字典类型")
    @PostMapping("add")
    public R add(@RequestBody DictType dictType) {
        return dictTypeService.save(dictType) ? R.ok() : R.error();
    }

    @ApiOperation(value = "根据字典类型id查询")
    @GetMapping("{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("dictType",dictTypeService.getById(id));
    }

    @ApiOperation("修改字典类型")
    @PostMapping("update")
    public R update(@RequestBody DictType dictType) {
        return dictTypeService.updateById(dictType)? R.ok(): R.error();
    }

}

