package com.example.service;

import com.example.bean.CollectedJob;
import com.example.config.RedisConstant;
import com.example.mapper.CollectedJobMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class CollectedJobService {
    @Autowired
    CollectedJobMapper collectedJobMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<CollectedJob> Select(String id) {
        List<CollectedJob> collectedJobs=(List<CollectedJob>) redisUtil.get(RedisConstant.COLLECT_KEY+id);
        if(CollectionUtils.isEmpty(collectedJobs)){
            collectedJobs= collectedJobMapper.Select(id);
            redisUtil.set(RedisConstant.COLLECT_KEY+id,collectedJobs);
        }
        return collectedJobs;
    }

}
