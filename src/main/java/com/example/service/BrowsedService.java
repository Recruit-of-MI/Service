package com.example.service;

import com.example.bean.Browsed;
import com.example.bean.Job;
import com.example.mapper.BrowsedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowsedService {
    @Autowired
    BrowsedMapper BrowsedMapper;

    public List<Browsed> Select(String id) {
        return BrowsedMapper.Select(id);
    }

    public Job Sel(int jobID) {
        return BrowsedMapper.Sel(jobID);
    }
}
