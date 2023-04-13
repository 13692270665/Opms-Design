package com.ccd.opms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.ccd.opms.entity.vo.ProceDesignQuery;
import com.ccd.opms.mapper.ProcessDesignMapper;
import com.ccd.opms.service.ProcessDesignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工艺设计表 服务实现类
 * </p>
 *
 * @author CCD
 * @since 2023-04-13
 */
@Service
public class ProcessDesignServiceImpl extends ServiceImpl<ProcessDesignMapper, ProcessDesign> implements ProcessDesignService {

    @Override
    public IPage<ProcessDesign> findPage(Page<ProcessDesign> myPage, ProceDesignQuery query) {
        return baseMapper.findPage(myPage,query);
    }
}
