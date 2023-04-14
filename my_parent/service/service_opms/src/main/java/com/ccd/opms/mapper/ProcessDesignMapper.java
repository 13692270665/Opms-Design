package com.ccd.opms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccd.opms.entity.ProcessDesign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccd.opms.entity.vo.ProceDesignQuery;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 工艺设计表 Mapper 接口
 * </p>
 *
 * @author CCD
 * @since 2023-04-13
 */
public interface ProcessDesignMapper extends BaseMapper<ProcessDesign> {

    IPage<ProcessDesign> findPage(Page<ProcessDesign> myPage, ProceDesignQuery query);

    ProcessDesign getDetail(String id);

    Boolean updatePD(ProcessDesign processDesign);

    Boolean check(String id, String status);
}
