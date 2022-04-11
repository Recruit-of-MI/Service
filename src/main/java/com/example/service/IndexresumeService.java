package com.example.service;

import com.example.bean.Indexresume;
import com.example.mapper.IndexresumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexresumeService {

    @Autowired
    IndexresumeMapper indexresumeMapper;

    public Indexresume Sel(String id) {
        return indexresumeMapper.SelectUser(id);
    }

    public Boolean Ins(Indexresume params) {
        try{
            indexresumeMapper.InsertUser(params);
            //能获取插入的id是因为indexresumemapper.xml的insert语句新增了useGeneratedKeys和keyProperty参数
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Upd(Indexresume params) {
        try{
            indexresumeMapper.UpdateUser(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}