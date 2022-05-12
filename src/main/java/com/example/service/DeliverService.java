package com.example.service;

import com.example.bean.Deliver;
import com.example.bean.Job;
import com.example.mapper.DeliverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliverService {
    @Autowired
    DeliverMapper deliverMapper;

    public List<Deliver> Select(String id) {
        return deliverMapper.Select(id);
    }

    public Job Sel(int jobID) {
        return deliverMapper.Sel(jobID);
    }

}
