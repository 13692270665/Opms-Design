package com.ccd.kbms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.kbms.entity.KnowContent;
import com.ccd.kbms.entity.vo.KnowContentQuery;
import com.ccd.kbms.service.KnowContentService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 内容信息表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-16
 */
@CrossOrigin
@Api(tags = "知识库管理-知识内容管理")
@RestController
@RequestMapping("/kbms/know_content")
public class KnowContentController {

    @Autowired
    private KnowContentService knowContentService;

    @ApiOperation("查询知识内容列表")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) KnowContentQuery query) {
        Page<KnowContent> page = new Page<>(current, limit);
        QueryWrapper<KnowContent> wrapper = new QueryWrapper<>();
        String author = query.getAuthor();
        String title = query.getTitle();
        Long typeId = query.getTypeId();
        if (!StringUtils.isEmpty(author)) wrapper.eq("author", author);
        if (!StringUtils.isEmpty(title)) wrapper.eq("title", title);
        if (!StringUtils.isEmpty(typeId)) wrapper.eq("type_id", typeId);
        wrapper.orderByDesc("create_time");
        knowContentService.page(page, wrapper);
        return R.ok().data("rows", page.getRecords()).data("total", page.getTotal());
    }

    @ApiOperation("查询知识内容")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok().data("data", knowContentService.getById(id));
    }

    @ApiOperation("发布/保存知识内容")
    @PostMapping("add")
    public R add(@RequestBody KnowContent knowContent) {
        return knowContentService.save(knowContent) ? R.ok() : R.error();
    }

    @ApiOperation("编辑/审核")
    @PostMapping("update")
    public R update(@RequestBody KnowContent knowContent) {
        return knowContentService.updateById(knowContent) ? R.ok() : R.error();
    }

    @ApiOperation("删除")
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Long id){
        return knowContentService.removeById(id)?R.ok():R.error();
    }

}

