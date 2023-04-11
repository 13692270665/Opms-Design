package com.ccd.kbms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.kbms.entity.LightMaterials;
import com.ccd.kbms.entity.ProcessLibrary;
import com.ccd.kbms.entity.vo.lMQuery;
import com.ccd.kbms.service.LightMaterialsService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 可见光材料库 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-11
 */
@CrossOrigin
@Api(tags = "知识库管理-可见光材料库")
@RestController
@RequestMapping("/kbms/light_materials")
public class LightMaterialsController {

    @Autowired
    private LightMaterialsService lightMaterialsService;

    @ApiOperation("查询工序列表")
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable Long current, @PathVariable Long limit,
                  @RequestBody(required = false) lMQuery query) {
        Page<LightMaterials> MyPage = new Page<>(current, limit);
        QueryWrapper<LightMaterials> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        String brandId = query.getBrandId();
        Integer brand = query.getBrand();
        String code = query.getCode();
        if (!StringUtils.isEmpty(brandId)) {
            wrapper.eq("brand_Id", brandId);
        }
        if (!StringUtils.isEmpty(brand)) {
            wrapper.eq("brand", brand);
        }
        if (!StringUtils.isEmpty(code)) {
            wrapper.eq("code", code);
        }
        //调用方法实现条件查询分页，并返回数据
        lightMaterialsService.page(MyPage, wrapper);
        List<LightMaterials> records = MyPage.getRecords();
        long total = MyPage.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    //excel 导入
}

