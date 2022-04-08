package com.example.mapper;

import com.example.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface userMapper {
    int InsertUser(user params);
    user SelectUser(int id);
}
