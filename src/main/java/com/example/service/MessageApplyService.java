package com.example.service;

import com.example.bean.MessageApply;
import com.example.config.RedisConstant;
import com.example.mapper.MessageApplyMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MessageApplyService {
    @Autowired
    MessageApplyMapper messageApplyMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<MessageApply> Select(String id) {
        List<MessageApply> messageApplys=(List<MessageApply>) redisUtil.get(RedisConstant.MESSAGE_APPLY_KEY+id);
        if(CollectionUtils.isEmpty(messageApplys)){
            messageApplys= messageApplyMapper.Select(id);
            redisUtil.set(RedisConstant.MESSAGE_APPLY_KEY+id,messageApplys);
        }
        return messageApplys;
    }

    public Boolean Insert(MessageApply params) {
        try{
            messageApplyMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Update(MessageApply params) {
        try{
            messageApplyMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
