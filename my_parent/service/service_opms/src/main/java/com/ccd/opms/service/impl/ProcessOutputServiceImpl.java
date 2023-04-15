package com.ccd.opms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.ProcessOutput;
import com.ccd.opms.entity.vo.ProceOutputQuery;
import com.ccd.opms.mapper.ProcessOutputMapper;
import com.ccd.opms.service.ProcessOutputService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工艺输出记录表 服务实现类
 * </p>
 *
 * @author CCD
 * @since 2023-04-15
 */
@Service
public class ProcessOutputServiceImpl extends ServiceImpl<ProcessOutputMapper, ProcessOutput> implements ProcessOutputService {

    @Override
    public IPage<ProcessDesign> findPage(Page<ProcessDesign> page, ProceOutputQuery query) {
        return baseMapper.findPage(page,query);
    }
}
