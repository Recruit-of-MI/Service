package com.example.mapper;

import com.example.bean.MessageApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface MessageApplyMapper {
    int Insert(MessageApply params);
    int Update(MessageApply params);
    List<MessageApply> Select(String id);
}
