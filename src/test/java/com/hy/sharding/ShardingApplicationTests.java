package com.hy.sharding;

import com.hy.sharding.soa.service.ActivityServiceImpl;
import javax.sql.DataSource;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingApplicationTests {

    @Autowired
    private ActivityServiceImpl activityService;

    @Test
    void t1() {
        activityService.getActivityById(78L);
        activityService.getActivityByPage();
        activityService.getActivityByPagePlugin();
    }

    @Autowired
    DataSource dataSource;

    @Test
    void t2(){


        for (int i = 0; i < 10; i++) {
            try(HintManager instance = HintManager.getInstance()){
               // instance.setDatabaseShardingValue(0);
                instance.addDatabaseShardingValue("activity","1");
                //instance.addDatabaseShardingValue("activity","ds1");
                assert  activityService.getActivityById(78L).getStoreCodes().startsWith("1");
            }
            try(HintManager instance = HintManager.getInstance()){
              //  instance.setDatabaseShardingValue(1);
                instance.addDatabaseShardingValue("activity","2");
                //instance.addDatabaseShardingValue("activity","ds2");
                assert activityService.getActivityById(78L).getStoreCodes().startsWith("2");
            }
        }
    }
}
