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
        redisUtil.del(RedisConstant.MESSAGE_APPLY_KEY+params.getUserID());
        try{
            messageApplyMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(MessageApply params) {
        redisUtil.del(RedisConstant.MESSAGE_APPLY_KEY+params.getUserID());
        try{
            messageApplyMapper.Update(params);
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
        redisUtil.del(RedisConstant.MESSAGE_APPLY_KEY+ID);
        try{
            messageApplyMapper.Delete(ID);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public MessageApply SelectBYChat(String id,String otherID) {
        return messageApplyMapper.SelectOne(id,otherID);
    }
    public Boolean UpdateByChat(String userID,String otherID,String avatarUrl,String userName,String content){
        redisUtil.del(RedisConstant.MESSAGE_APPLY_KEY+userID);
        MessageApply messageApply = SelectBYChat(userID,otherID);
        if (messageApply==null) return false;
        messageApply.setOtherID(otherID);
        messageApply.setOtherAvatarUrl(avatarUrl);
        messageApply.setOtherUserName(userName);
        messageApply.setLatestMessage(content);
        return Update(messageApply);
    }
}
