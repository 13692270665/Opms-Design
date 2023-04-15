package com.ccd.opms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.ProcessOutput;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ccd.opms.entity.vo.ProceOutputQuery;

/**
 * <p>
 * 工艺输出记录表 服务类
 * </p>
 *
 * @author CCD
 * @since 2023-04-15
 */
public interface ProcessOutputService extends IService<ProcessOutput> {

    IPage<ProcessOutput> findPage(Page<ProcessOutput> page, ProceOutputQuery query);
}
