package com.example.service;

import com.example.bean.Job;
import com.example.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobMapper jobMapper;

    public List<Job> Search() {
        return jobMapper.SelectAll();
    }

    public Job Sel(int jobID) {
        return jobMapper.Sel(jobID);
    }

    public Boolean Ins(Job params) {
        try{
            jobMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Upd(Job params) {
        try{
            jobMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
