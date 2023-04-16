package com.ccd.kbms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.kbms.entity.KnowType;
import com.ccd.kbms.entity.vo.lMQuery;
import com.ccd.kbms.service.KnowTypeService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 栏目信息表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-16
 */
@CrossOrigin
@Api(tags = "知识库管理-知识分类管理")
@RestController
@RequestMapping("/kbms/know_type")
public class KnowTypeController {

    @Autowired
    private KnowTypeService knowTypeService;

    @ApiOperation("查询知识分类列表")
    @PostMapping("list")
    public R list(){
        QueryWrapper<KnowType> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("order_num");
        return R.ok().data("data",knowTypeService.list(wrapper));
    }

    @ApiOperation("查询知识分类")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable Integer id){
        return R.ok().data("data",knowTypeService.getById(id));
    }

    @ApiOperation("添加知识分类")
    @PostMapping("add")
    public R add(@RequestBody KnowType knowType){
        return knowTypeService.save(knowType) ? R.ok() : R.error();
    }

    @ApiOperation("修改知识分类")
    @PostMapping("update")
    public R update(@RequestBody KnowType knowType){
        return knowTypeService.updateById(knowType)? R.ok() : R.error();
    }

    @ApiOperation("删除")
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return knowTypeService.removeById(id) ? R.ok() : R.error();
    }

}

