package com.example.service;

import com.example.bean.Indexresume;
import com.example.mapper.IndexresumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexresumeService {

    @Autowired
    IndexresumeMapper indexresumeMapper;

    public Indexresume Sel(int id) {
        Indexresume indexresume = indexresumeMapper.SelectUser(id);
        return indexresume;
    }

    public Boolean Ins(Indexresume params) {
        Integer result = indexresumeMapper.InsertUser(params);
        //能获取插入的id是因为UserMapper.xml的insert语句新增了useGeneratedKeys和keyProperty参数
        String insertId = params.getUserID();
        System.out.println("插入数据的ID: " + insertId);
        System.out.println("insert结果: " + result);
        // insert返回结果为 1，表示插入了一条数据
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}