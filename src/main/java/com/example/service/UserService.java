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
        User user = userMapper.SelectUser(id);
        return user;
    }

    public Boolean Ins(User params) {
        Integer result = userMapper.InsertUser(params);
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