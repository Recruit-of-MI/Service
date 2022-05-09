package com.example.mapper;

import com.example.bean.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface JobMapper {
    int Insert(Job params);
    int Update(Job params);
    Job Select();
}
