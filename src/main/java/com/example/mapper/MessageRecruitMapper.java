package com.example.mapper;

import com.example.bean.MessageApply;
import com.example.bean.MessageRecruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface MessageRecruitMapper {
    int Insert(MessageRecruit params);
    int Update(MessageRecruit params);
    int Delete(Integer ID);
    List<MessageRecruit> Select(String userID);
}
