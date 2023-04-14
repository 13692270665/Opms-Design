package com.ccd.opms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.ProcessDesignAudit;
import com.ccd.opms.service.ProcessDesignAuditService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 工艺设计审核表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-14
 */
@CrossOrigin
@Api(tags = "光学零件管理-工艺设计审核校对")
@RestController
@RequestMapping("/opms/process_design-audit")
public class ProcessDesignAuditController {

    @Autowired
    private ProcessDesignAuditService processDesignAuditService;

    @ApiOperation(value = "根据工艺设计id进行查询")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<ProcessDesignAudit> wrapper = new QueryWrapper<>();
        wrapper.eq("process_design_id", id);
        return R.ok().data("data",processDesignAuditService.list(wrapper));
    }

}

