package com.ccd.temp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.temp.entity.DictData;
import com.ccd.temp.entity.ProcessTemplate;
import com.ccd.temp.entity.Vo.DictDataQuery;
import com.ccd.temp.entity.Vo.ProceTempQuery;
import com.ccd.temp.service.ProcessTemplateService;
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
 * 工艺流程模板表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-11
 */
@CrossOrigin
@Api(tags = "模板配置管理-工艺流程模板")
@RestController
@RequestMapping("/temp/process_template")
public class ProcessTemplateController {

    @Autowired
    private ProcessTemplateService processTemplateService;

    @ApiOperation("查询工艺流程模板")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) ProceTempQuery query) {
        Page<ProcessTemplate> MyPage = new Page<>(current, limit);
        //构建条件
        QueryWrapper<ProcessTemplate> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String templateName = query.getTemplateName();
        String createBy = query.getCreateBy();
        String templateType = query.getTemplateType();
        if (!StringUtils.isEmpty(templateName)) {
            wrapper.eq("template_name", templateName);
        }
        if (!StringUtils.isEmpty(createBy)) {
            wrapper.eq("create_by", createBy);
        }
        if (!StringUtils.isEmpty(templateType)) {
            wrapper.eq("template_type", templateType);
        }
        wrapper.orderByDesc("create_time");
        //调用方法实现条件查询分页，并返回数据
        processTemplateService.page(MyPage, wrapper);
        List<ProcessTemplate> records = MyPage.getRecords();
        long total = MyPage.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("根据id删除工艺流程模板")
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Collection<Serializable> id) {
        return processTemplateService.removeByIds(id) ? R.ok() : R.error();
    }

    @ApiOperation("新增工艺流程模板")
    @PostMapping("add")
    public R add(@RequestBody ProcessTemplate processTemplate) {
        return processTemplateService.save(processTemplate) ? R.ok() : R.error();
    }

    @ApiOperation(value = "根据工艺流程模板id查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("data",processTemplateService.getById(id));
    }

    @ApiOperation("修改工艺流程模板")
    @PostMapping("update")
    public R update(@RequestBody ProcessTemplate processTemplate) {
        return processTemplateService.updateById(processTemplate)? R.ok(): R.error();
    }
    
}

