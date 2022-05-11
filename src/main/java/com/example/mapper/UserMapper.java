package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapper {
    int Insert(User params);
    int Update(User params);
    User Select(String userID);
}
