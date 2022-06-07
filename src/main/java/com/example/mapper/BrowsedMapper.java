package com.example.mapper;

import com.example.bean.Browsed;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface BrowsedMapper {
    int Insert(Browsed params);
    int Update(Browsed params);
    List<Browsed> Select(String id);
    Browsed SelectOne(String userID,Integer jobID);
    int Delete(Browsed params);
}
