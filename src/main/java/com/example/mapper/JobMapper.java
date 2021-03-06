package com.example.mapper;

import com.example.bean.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface JobMapper {
    int Insert(Job params);
    int Update(Job params);
    List<Job> SelectAll();
    List<Job> SelectRegion(String region);
    List<Job> SelectIncludeKey(String key);
    List<Job> SelectHighPay();
    List<Job> SelectSend(String userID);
    Job Select(int jobID);
}
