package com.example.service;

import com.example.bean.Job;
import com.example.config.RedisConstant;
import com.example.mapper.JobMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.Collections;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobMapper jobMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<Job> SelectAll() {
        List<Job> jobs=jobMapper.SelectAll();
        Collections.shuffle(jobs);
        return jobs;
    }

    public List<Job> SelectLatest() {
        List<Job> jobs=jobMapper.SelectAll();
        Collections.reverse(jobs);
        return jobs;
    }

    public List<Job> SelectHighPay() {
        List<Job> jobs=jobMapper.SelectHighPay();
        Collections.reverse(jobs);
        return jobs;
    }

    public List<Job> SelectSend(String userID) {
        List<Job> jobs=jobMapper.SelectSend(userID);
        Collections.reverse(jobs);
        return jobs;
    }

    public List<Job> SelectNearLatest(String region) {
        List<Job> jobs=jobMapper.SelectRegion(region);
        Collections.reverse(jobs);
        return jobs;
    }

    public List<Job> SelectIncludeKey(String key) {
        List<Job> jobs=jobMapper.SelectIncludeKey(key);
        Collections.shuffle(jobs);
        return jobs;
    }

    public Job Select(int jobID) {
        Job job=(Job) redisUtil.get(RedisConstant.JOB_KEY+jobID);
        if(job==null){
            job=jobMapper.Select(jobID);
            redisUtil.set(RedisConstant.JOB_KEY+jobID,job);
        }
        return job;
    }

    public Boolean Insert(Job params) {
        redisUtil.del(RedisConstant.JOB_KEY);
        try{
            jobMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean Update(Job params) {
        redisUtil.del(RedisConstant.JOB_KEY);
        redisUtil.del(RedisConstant.JOB_KEY+params.getUserID());
        try{
            jobMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
