package com.example.mapper;

import com.example.bean.MessageApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface MessageApplyMapper {
    int InsertUser(MessageApply params);
    int UpdateUser(MessageApply params);
    MessageApply SelectUser(String id);
}
