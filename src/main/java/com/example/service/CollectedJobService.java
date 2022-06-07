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

    public List<CollectedJob> Select(String id){
        List<CollectedJob> collectedJobs=(List<CollectedJob>) redisUtil.get(RedisConstant.COLLECT_KEY+id);
        if(CollectionUtils.isEmpty(collectedJobs)){
            collectedJobs= collectedJobMapper.Select(id);
            redisUtil.set(RedisConstant.COLLECT_KEY+id,collectedJobs);
        }
        return collectedJobs;
    }

    public CollectedJob SelectSpecific(String userID, Integer jobID) {
        CollectedJob collectedJob=collectedJobMapper.SelectSpecific(userID,jobID);
        return collectedJob;
    }
    public Boolean Insert(CollectedJob params) {
        redisUtil.del(RedisConstant.COLLECT_KEY+params.getUserID());
        try{
            CollectedJob collectedJob=SelectSpecific(params.getUserID(),params.getJobID());
            if (collectedJob==null) collectedJobMapper.Insert(params);
            else {
                if (Delete(collectedJob)){
                    collectedJobMapper.Insert(params);
                }
                else return false;
            }
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(CollectedJob params) {
        redisUtil.del(RedisConstant.COLLECT_KEY+params.getUserID());
        try{
            collectedJobMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Delete(CollectedJob params) {
        redisUtil.del(RedisConstant.COLLECT_KEY+params.getUserID());
        try{
            collectedJobMapper.Delete(params);
            String insertId = params.getUserID();
            System.out.println("删除数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
