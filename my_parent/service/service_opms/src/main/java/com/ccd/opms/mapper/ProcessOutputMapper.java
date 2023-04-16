package com.ccd.opms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.ProcessOutput;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccd.opms.entity.vo.ProceOutputQuery;

/**
 * <p>
 * 工艺输出记录表 Mapper 接口
 * </p>
 *
 * @author CCD
 * @since 2023-04-15
 */
public interface ProcessOutputMapper extends BaseMapper<ProcessOutput> {

    IPage<ProcessOutput> findPage(Page<ProcessOutput> page, ProceOutputQuery query);

    Boolean updateStatus(Integer id, String status);
}
