package com.example.mapper;

import com.example.bean.MessageRecruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface MessageRecruitMapper {
    int Insert(MessageRecruit params);
    int Update(MessageRecruit params);
    MessageRecruit Select(String id);
}
