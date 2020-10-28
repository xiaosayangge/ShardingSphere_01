package com.hy.sharding.soa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.sharding.soa.model.ActivityModel;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper extends BaseMapper<ActivityModel> {

    ActivityModel hyById(@Param("id") Long id);
}
