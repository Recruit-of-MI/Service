package com.example.service;

import com.example.bean.CollectedJob;
import com.example.bean.Job;
import com.example.mapper.CollectedJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectedJobService {
    @Autowired
    CollectedJobMapper collectedJobMapper;

    public List<CollectedJob> Select(String id) {
        return collectedJobMapper.Select(id);
    }

    public Job Sel(int jobID) {
        return collectedJobMapper.Sel(jobID);
    }
}
