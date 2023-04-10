package com.ccd.kbms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.kbms.entity.ProcessLibrary;
import com.ccd.kbms.entity.vo.pLQuery;
import com.ccd.kbms.service.ProcessLibraryService;
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
 * 工序表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-10
 */
@CrossOrigin
@Api(tags = "知识库管理-工艺工序库")
@RestController
@RequestMapping("/kbms/process-library")
public class ProcessLibraryController {

    @Autowired
    private ProcessLibraryService processLibraryService;

    @ApiOperation("查询工序列表")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) pLQuery query) {
        Page<ProcessLibrary> MyPage = new Page<>(current, limit);
        //构建条件
        QueryWrapper<ProcessLibrary> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String processName = query.getProcessName();
        if (!StringUtils.isEmpty(processName)) {
            wrapper.eq("process_name", processName);
        }
        //调用方法实现条件查询分页，并返回数据
        processLibraryService.page(MyPage, wrapper);
        List<ProcessLibrary> records = MyPage.getRecords();
        long total = MyPage.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "根据工序id查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("data", processLibraryService.getById(id));
    }

    @ApiOperation("新增工序")
    @PostMapping("add")
    public R add(@RequestBody ProcessLibrary processLibrary) {
        return processLibraryService.save(processLibrary) ? R.ok() : R.error();
    }

    @ApiOperation("修改工序")
    @PostMapping("update")
    public R update(@RequestBody ProcessLibrary processLibrary) {
        return processLibraryService.updateById(processLibrary) ? R.ok() : R.error();
    }

    @ApiOperation("根据字典id删除数据字典")
    @DeleteMapping("delete/{ids}")
    public R remove(@PathVariable Collection<Serializable> ids) {
        return processLibraryService.removeByIds(ids) ? R.ok() : R.error();
    }

}

