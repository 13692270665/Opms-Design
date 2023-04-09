package com.ccd.temp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.temp.entity.DictData;
import com.ccd.temp.entity.DictType;
import com.ccd.temp.entity.Vo.DictDataQuery;
import com.ccd.temp.entity.Vo.TempQuery;
import com.ccd.temp.service.DictDataService;
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
 * 字典数据表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-09
 */
@CrossOrigin
@Api(tags = "模板配置管理-数据字典")
@RestController
@RequestMapping("/temp/dict_data")
public class DictDataController {

    @Autowired
    private DictDataService dictDataService;

    @ApiOperation("条件查询字典类型带分页")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) DictDataQuery query) {
        Page<DictData> MyPage = new Page<>(current, limit);
        //构建条件
        QueryWrapper<DictData> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String dictLabel = query.getDictLabel();
        String dictType = query.getDictType();
        if (!StringUtils.isEmpty(dictLabel)) {
            wrapper.eq("dict_label", dictLabel);
        }
        if (!StringUtils.isEmpty(dictType)) {
            wrapper.eq("dict_type", dictType);
        }
        wrapper.orderByAsc("dict_sort");
        //调用方法实现条件查询分页，并返回数据
        dictDataService.page(MyPage, wrapper);
        List<DictData> records = MyPage.getRecords();
        long total = MyPage.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("根据字典id删除数据字典")
    @DeleteMapping("delete/{dictDataId}")
    public R remove(@PathVariable Collection<Serializable> dictDataId) {
        return dictDataService.removeByIds(dictDataId) ? R.ok() : R.error();
    }

    @ApiOperation("新增数据字典")
    @PostMapping("add")
    public R add(@RequestBody DictData dictData) {
        return dictDataService.save(dictData) ? R.ok() : R.error();
    }

    @ApiOperation(value = "根据字典类型id查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("dictData",dictDataService.getById(id));
    }

    @ApiOperation("修改数据字典")
    @PostMapping("update")
    public R update(@RequestBody DictData dictData) {
        return dictDataService.updateById(dictData)? R.ok(): R.error();
    }

}

