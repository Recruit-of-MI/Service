package com.example.service;

import com.example.bean.ChatMessage;
import com.example.config.RedisConstant;
import com.example.mapper.ChatMessageMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    ChatMessageMapper chatMessageMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<ChatMessage> Select(String userID, String otherID) {
        List<ChatMessage> chatMessages=(List<ChatMessage>) redisUtil.get(RedisConstant.CHAT_KEY+userID+otherID);
        if(CollectionUtils.isEmpty(chatMessages)){
            chatMessages= chatMessageMapper.Select(userID,otherID);
            redisUtil.set(RedisConstant.CHAT_KEY+userID+otherID,chatMessages);
        }
        return chatMessages;
    }

    public Boolean Insert(ChatMessage params) {
        redisUtil.del(RedisConstant.CHAT_KEY+params.getUserID()+params.getOtherID());
        try{
            chatMessageMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(ChatMessage params) {
        redisUtil.del(RedisConstant.CHAT_KEY+params.getUserID()+params.getOtherID());
        try{
            chatMessageMapper.Update(params);
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
