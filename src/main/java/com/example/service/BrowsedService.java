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
    private BrowsedMapper browsedMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<Browsed> Select(String id) {
        List<Browsed> browseds=(List<Browsed>) redisUtil.get(RedisConstant.BROSE_KEY+id);
        if(CollectionUtils.isEmpty(browseds)){
            browseds=browsedMapper.Select(id);
            redisUtil.set(RedisConstant.BROSE_KEY+id,browseds);
        }
        return browseds;
    }
    public Boolean Insert(Browsed params) {
        redisUtil.del(RedisConstant.BROSE_KEY+params.getUserID());
        try{
            browsedMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(Browsed params) {
        redisUtil.del(RedisConstant.BROSE_KEY+params.getUserID());
        try{
            browsedMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
