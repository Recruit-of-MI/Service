package com.example.service;

import com.example.bean.Resume;
import com.example.config.RedisConstant;
import com.example.mapper.ResumeMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    ResumeMapper resumeMapper;

    @Autowired
    private RedisUtil redisUtil;

    public Resume Select(String id) {
        Resume resume=(Resume) redisUtil.get(RedisConstant.RESUME_KEY +id);
        if(resume==null){
            resume=resumeMapper.Select(id);
            redisUtil.set(RedisConstant.RESUME_KEY+id,resume);
        }
        return resume;
    }

    public Boolean Insert(Resume params) {
        try{
            resumeMapper.Insert(params);
            //能获取插入的id是因为resumemapper.xml的insert语句新增了useGeneratedKeys和keyProperty参数
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Update(Resume params) {
        try{
            resumeMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}