package com.example.mapper;

import com.example.bean.MessageRecruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface MessageRecruitMapper {
    int Insert(MessageRecruit params);
    int Update(MessageRecruit params);
    List<MessageRecruit> Select(String id);
}
