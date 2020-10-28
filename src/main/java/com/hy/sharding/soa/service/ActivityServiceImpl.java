package com.hy.sharding.soa.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.hy.sharding.soa.mapper.ActivityMapper;
import com.hy.sharding.soa.model.ActivityModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl  {

    private ActivityMapper activityMapper;

    public ActivityServiceImpl(ActivityMapper activityMapper){
        this.activityMapper=activityMapper;
    }

    public ActivityModel getActivityById(Long id){
        //ActivityModel activityModel = activityMapper.selectById(id);
        return activityMapper.hyById(id);

    }

    public void getActivityByPage(){
        IPage<ActivityModel> page=new Page<>(1,10);
        LambdaQueryWrapper<ActivityModel> wrapper = Wrappers.<ActivityModel>lambdaQuery()
                .in(ActivityModel::getCreateId, "test2");
        IPage<ActivityModel> activityModelIPage = activityMapper.selectPage(page, wrapper);
        System.out.println(activityModelIPage.getRecords());
    }

    public void getActivityByPagePlugin(){
        PageHelper.startPage(2,10);
        LambdaQueryWrapper<ActivityModel> wrapper = Wrappers.<ActivityModel>lambdaQuery()
                .in(ActivityModel::getCreateId, "test2");
        List<ActivityModel> activityModels = activityMapper.selectList(wrapper);
        System.out.println(activityModels);
    }

}
