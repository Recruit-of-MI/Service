package com.example.mapper;

import com.example.bean.CollectedJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface CollectedJobMapper {
    int Insert(CollectedJob params);
    int Update(CollectedJob params);
    List<CollectedJob> Select(String id);
    CollectedJob SelectSpecific(String userID,Integer jobID);
}
