package com.ccd.opms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.ProcessDesignAudit;
import com.ccd.opms.service.OpmsDesignDataService;
import com.ccd.opms.service.ProcessDesignAuditService;
import com.ccd.opms.service.ProcessDesignService;
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
    @Autowired
    private ProcessDesignService processDesignService;

    @ApiOperation(value = "审核/校核成功或失败")
    @PostMapping("checkSuccess")
    public R checkSuccess(@RequestBody ProcessDesignAudit processDesignAudit) {
        // 修改工艺设计的状态
        String status = processDesignAudit.getStatus();
        String id = processDesignAudit.getProcessDesignId();
        processDesignService.check(id,status);
        // 添加审核/校核记录
        return processDesignAuditService.save(processDesignAudit) ? R.ok() : R.error();
    }

    @ApiOperation(value = "查询审核记录")
    @GetMapping("getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<ProcessDesignAudit> wrapper = new QueryWrapper<>();
        wrapper.eq("process_design_id", id);
        return R.ok().data("data",processDesignAuditService.list(wrapper));
    }

}

