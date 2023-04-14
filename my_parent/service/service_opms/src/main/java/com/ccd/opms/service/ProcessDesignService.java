package com.ccd.opms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ccd.opms.entity.vo.ProceDesignQuery;

/**
 * <p>
 * 工艺设计表 服务类
 * </p>
 *
 * @author CCD
 * @since 2023-04-13
 */
public interface ProcessDesignService extends IService<ProcessDesign> {

    IPage<ProcessDesign> findPage(Page<ProcessDesign> page, ProceDesignQuery query);

    ProcessDesign getDetail(String id);

    Boolean updatePD(ProcessDesign processDesign);
}
