package com.example.mapper;

import com.example.bean.Deliver;
import com.example.bean.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface DeliverMapper {
    int Insert(Deliver params);
    int Update(Deliver params);
    List<Deliver> Select(String id);
    Job Sel(int jobID);
}
