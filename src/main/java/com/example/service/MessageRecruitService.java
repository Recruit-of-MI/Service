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
        try{
            messageRecruitMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Update(MessageRecruit params) {
        try{
            messageRecruitMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
