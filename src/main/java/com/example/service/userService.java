package com.example.service;

import com.example.bean.user;
import com.example.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    userMapper userMapper;

    public user Sel(int id) {
        user user = userMapper.SelectUser(id);

        return user;
    }

    public int Ins(user params) {
        Integer result = userMapper.InsertUser(params);
        //能获取插入的id是因为UserMapper.xml的insert语句新增了useGeneratedKeys和keyProperty参数
        Integer insertId = params.getId();
        System.out.println("插入数据的ID: " + insertId);
        System.out.println("insert结果: " + result);
        // insert返回结果为 1，表示插入了一条数据
        if (result == 1) {
            return insertId;
        } else {
            return 0;
        }
    }
}