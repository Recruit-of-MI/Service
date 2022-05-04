package com.example.mapper;

import com.example.bean.MessageApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface MessageApplyMapper {
    int Insert(MessageApply params);
    int Update(MessageApply params);
    MessageApply Select(String id);
}
