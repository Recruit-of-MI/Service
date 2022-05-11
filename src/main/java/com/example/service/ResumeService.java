package com.example.service;

import com.example.bean.Resume;
import com.example.mapper.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    ResumeMapper resumeMapper;

    public Resume Sel(String id) {
        return resumeMapper.Select(id);
    }

    public Boolean Ins(Resume params) {
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
    public Boolean Upd(Resume params) {
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