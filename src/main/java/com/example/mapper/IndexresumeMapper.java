package com.example.mapper;

import com.example.bean.Indexresume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface IndexresumeMapper {
    int Insert(Indexresume params);
    int Update(Indexresume params);
    Indexresume Select(String id);
}
