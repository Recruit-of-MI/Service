package com.example.service;

import com.example.bean.MessageRecruit;
import com.example.config.RedisConstant;
import com.example.mapper.MessageRecruitMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class MessageRecruitService {
    @Autowired
    MessageRecruitMapper messageRecruitMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<MessageRecruit> Select(String id) {
        List<MessageRecruit> messageRecruits=(List<MessageRecruit>) redisUtil.get(RedisConstant.MESSAGE_RECRUIT_KEY+id);
        if(CollectionUtils.isEmpty(messageRecruits)){
            messageRecruits= messageRecruitMapper.Select(id);
            redisUtil.set(RedisConstant.MESSAGE_RECRUIT_KEY+id,messageRecruits);
        }
        return messageRecruits;
    }

    public Boolean Insert(MessageRecruit params) {
        redisUtil.del(RedisConstant.MESSAGE_RECRUIT_KEY+params.getUserID());
        try{
            messageRecruitMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(MessageRecruit params) {
        redisUtil.del(RedisConstant.MESSAGE_RECRUIT_KEY+params.getUserID());
        try{
            messageRecruitMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Delete(int ID) {
        redisUtil.del(RedisConstant.MESSAGE_RECRUIT_KEY+ID);
        try{
            messageRecruitMapper.Delete(ID);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
