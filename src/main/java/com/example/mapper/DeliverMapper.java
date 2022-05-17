package com.example.mapper;

import com.example.bean.Deliver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Mapper
public interface DeliverMapper {
    int Insert(Deliver params);
    int Update(Deliver params);
    List<Deliver> Select(String id);
}
