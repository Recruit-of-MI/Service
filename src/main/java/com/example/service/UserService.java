package com.example.service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User Sel(String id) {
        return userMapper.Select(id);
    }

    public Boolean Ins(User params) {
        try{
            userMapper.Insert(params);
            //能获取插入的id是因为UserMapper.xml的insert语句新增了useGeneratedKeys和keyProperty参数
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Upd(User params) {
        try{
            userMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}