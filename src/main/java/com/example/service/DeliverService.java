package com.example.service;

import com.example.bean.Deliver;
import com.example.config.RedisConstant;
import com.example.mapper.DeliverMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class DeliverService {
    @Autowired
    DeliverMapper deliverMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<Deliver> Select(String id) {
        List<Deliver> delivers=(List<Deliver>) redisUtil.get(RedisConstant.DELIVER_KEY+id);
        if(CollectionUtils.isEmpty(delivers)){
            delivers= deliverMapper.Select(id);
            redisUtil.set(RedisConstant.DELIVER_KEY+id,delivers);
        }
        return delivers;
    }
    public Boolean Insert(Deliver params) {
        redisUtil.del(RedisConstant.DELIVER_KEY+params.getUserID());
        try{
            deliverMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Update(Deliver params) {
        redisUtil.del(RedisConstant.DELIVER_KEY+params.getUserID());
        try{
            deliverMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

}
