package com.example.service;

import com.example.bean.User;
import com.example.config.RedisConstant;
import com.example.mapper.UserMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    public User Select(String id) {
        User user=(User) redisUtil.get(RedisConstant.USER_KEY +id);
        if(user==null){
            user=userMapper.Select(id);
            redisUtil.set(RedisConstant.USER_KEY+id,user);
        }
        return user;
    }

    public Boolean Insert(User params) {
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
    public Boolean Update(User params) {
        redisUtil.del(RedisConstant.USER_KEY+params.getUserID());
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