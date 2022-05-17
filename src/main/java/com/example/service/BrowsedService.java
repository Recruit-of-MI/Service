package com.example.service;

import com.example.bean.Browsed;
import com.example.config.RedisConstant;
import com.example.mapper.BrowsedMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class BrowsedService {
    @Autowired
    private BrowsedMapper BrowsedMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<Browsed> Select(String id) {
        List<Browsed> browseds=(List<Browsed>) redisUtil.get(RedisConstant.BROSE_KEY+id);
        if(CollectionUtils.isEmpty(browseds)){
            browseds=BrowsedMapper.Select(id);
            redisUtil.set(RedisConstant.BROSE_KEY+id,browseds);
        }
        return browseds;
    }
}
