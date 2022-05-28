package com.example.mapper;

import com.example.bean.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface ChatMessageMapper {
    int Insert(ChatMessage params);
    int Update(ChatMessage params);
    List<ChatMessage> Select(String userID,String otherID);
}
