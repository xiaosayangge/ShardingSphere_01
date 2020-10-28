package com.hy.sharding.config;

import java.util.Collection;
import java.util.stream.Collectors;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

public class HintShardingAlgorithmImpl implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
            HintShardingValue<String> shardingValue) {
        return shardingValue.getValues().stream().map(v->"ds"+v).collect(Collectors.toList());
    }
}
