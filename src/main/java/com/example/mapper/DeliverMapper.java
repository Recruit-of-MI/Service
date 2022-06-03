package com.example.mapper;

import com.example.bean.Deliver;
import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface DeliverMapper {
    int Insert(Deliver params);
    int Update(Deliver params);
    Deliver SelectOne(String userID,Integer jobID);
    List<Deliver> Select(String id);
    List<Deliver> SelectUser(Integer jobID);
}
