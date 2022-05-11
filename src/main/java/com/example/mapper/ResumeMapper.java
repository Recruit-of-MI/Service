package com.example.mapper;

import com.example.bean.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface ResumeMapper {
    int Insert(Resume params);
    int Update(Resume params);
    Resume Select(String userID);
}
