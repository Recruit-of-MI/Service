package com.example.mapper;

import com.example.bean.Indexresume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface IndexresumeMapper {
    int InsertUser(Indexresume params);
    Indexresume SelectUser(int id);
}
