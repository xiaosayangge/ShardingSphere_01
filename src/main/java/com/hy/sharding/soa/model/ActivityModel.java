package com.hy.sharding.soa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hy.sharding.util.GsonUtils;
import java.util.Date;
import lombok.Data;

@TableName("activity")
@Data
public class ActivityModel {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String activityName;

    private String lineSeq;

    private Date createTime;

    private String createId;

    private String storeCodes;

    @Override
    public String toString() {
        return GsonUtils.toJson(this);
    }
}
